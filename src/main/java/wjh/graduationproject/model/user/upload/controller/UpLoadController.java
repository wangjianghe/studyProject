package wjh.graduationproject.model.user.upload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import wjh.graduationproject.common.BuildUUID;
import wjh.graduationproject.common.JudgeNull;
import wjh.graduationproject.entity.ArticleEntity;
import wjh.graduationproject.entity.ArticleType;
import wjh.graduationproject.entity.UserEntity;
import wjh.graduationproject.model.article.dao.ArticleMapper;
import wjh.graduationproject.model.user.upload.service.UpLoadService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/4/2.
 */
@Controller
public class UpLoadController {
    @Autowired
    UpLoadService upLoadService;
    @Autowired
    ArticleMapper articleMapper;
    @RequestMapping("/upLoad")
    public ModelAndView upLoadPage(HttpServletRequest request,String articleId){
        ModelAndView modelAndView=new ModelAndView();
        UserEntity userEntity= (UserEntity) request.getSession().getAttribute("user");
        if (request.getSession().getAttribute("user")!=null){
            List<ArticleType> types=articleMapper.getTypes();
            ArticleType zero=null;
            if (userEntity.getTypes()!=0){
                for (ArticleType a:types){
                    if (a.getTypeId().equals("0")){
                        zero=a;
                    }
                }
                types.remove(zero);
            }
            if (JudgeNull.isNotNull(articleId)){
                ArticleEntity articleEntity=articleMapper.getArticle(articleId);
                modelAndView.addObject("article",articleEntity);
            }
            modelAndView.setViewName("upLoad");
            modelAndView.addObject("types",types);
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/signIn");
        return modelAndView;
    }
    @RequestMapping("/saveFile")
    public ModelAndView saveFile(String articleType,MultipartFile[] files, String context, MultipartFile articleImage,
                                 String title, String shortContext, HttpServletRequest request) throws IOException {
        ModelAndView modelAndView=new ModelAndView();
        String uuid= BuildUUID.getUUID();
        ArticleEntity articleEntity=new ArticleEntity();
        if (request.getSession().getAttribute("user")==null){
            modelAndView.setViewName("redirect:/signUp/");
        }
        UserEntity userEntity= (UserEntity) request.getSession().getAttribute("user");
        String imageString="";
        if (!articleImage.isEmpty()){
            imageString=upLoadService.saveArticelImg(userEntity,articleImage,uuid);
            if (!imageString.equals("-1")||!imageString.equals("-2")){
                articleEntity.setArticleImg(imageString);
            }
        }
        for (MultipartFile file:files){
            System.out.println(file);
        }
        String fileString=upLoadService.saveUpFile(files,userEntity,uuid);
        if (!fileString.equals("0")){
            articleEntity.setArticleFile(fileString);
        }
        System.out.println(fileString+":"+imageString);
        articleEntity.setArticleId(uuid);
        articleEntity.setArticleReadNum(0);
        articleEntity.setArticleShortContext(shortContext);
        articleEntity.setArticleTime(new Date());
        articleEntity.setArticleTitle(title);
        articleEntity.setArticleType(articleType);
        articleEntity.setUserId(userEntity.getId());
        articleEntity.setUserName(userEntity.getUserName());
        articleEntity.setArticleContext(context);
        articleMapper.insertArticles(articleEntity);
        articleMapper.addTypes(articleType);
        modelAndView.setViewName("redirect:/index");
        return modelAndView;
    }
}
