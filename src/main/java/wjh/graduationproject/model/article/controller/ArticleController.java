package wjh.graduationproject.model.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import wjh.graduationproject.common.DeleteFileUtil;
import wjh.graduationproject.common.JudgeNull;
import wjh.graduationproject.entity.ArticleEntity;
import wjh.graduationproject.entity.ArticleType;
import wjh.graduationproject.entity.DownloadFileName;
import wjh.graduationproject.entity.UserEntity;
import wjh.graduationproject.model.article.dao.ArticleMapper;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/30.
 */
@Controller
public class ArticleController {
    @Autowired
    ArticleMapper articleMapper;
    @RequestMapping(value = "searchArticle")
    public ModelAndView searchArticle(String search){
        ModelAndView modelAndView=new ModelAndView();
        return modelAndView;
    }
    @RequestMapping(value = "checkArticleByType")
    public ModelAndView checkArticleByType(String typeId){
        ModelAndView modelAndView=new ModelAndView();
        //根据数据返回类型
        return modelAndView;
    }
    @RequestMapping(value = "/showImg")
    @ResponseBody
    public void showImg(HttpServletRequest request, HttpServletResponse response,String pathName) {
        File imgFile = new File(pathName);
        FileInputStream fin=null;
        OutputStream output=null;
        try {
            output=response.getOutputStream();
            fin=new FileInputStream(imgFile);
            byte[] arr = new byte[1024*10];
            int n;
            while((n=fin.read(arr))!= -1){
                output.write(arr, 0, n);
            }
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/showArticle")
    public ModelAndView showArticle(@RequestParam(name = "articleId")String articleId){
        System.out.println(articleId);
        ModelAndView modelAndView=new ModelAndView();
        ArticleEntity ae=articleMapper.getArticle(articleId);
        System.out.println(ae);
        if (ae==null|| JudgeNull.IsNull(ae.getArticleId())){
            modelAndView.setViewName("tips");
            modelAndView.addObject("tips","文章不存在");
            modelAndView.addObject("redirectUrl","/index");
            return modelAndView;
        }
        if (JudgeNull.isNotNull(ae.getArticleFile())&&ae.getArticleFile().length()>4){
            String[] files=ae.getArticleFile().split(";");
            System.out.println(files.length);
            List<DownloadFileName> DownList=new LinkedList<>();
            for (String file:files){
                System.out.println(file);
                String[] fileName=file.split("_");
                DownList.add(new DownloadFileName(file,fileName[1]));
            }
            modelAndView.addObject("files",DownList);
            System.out.println(files);
        }
        articleMapper.updateArticleReadNum(articleId);
        modelAndView.addObject("article",ae);
        List<ArticleType> types=articleMapper.getTypes();
        //侧栏
        modelAndView.addObject("types",types);
        modelAndView.addObject("noticeSide",articleMapper.getNoticeSide());
        modelAndView.addObject("articleSide",articleMapper.getArticleSide());
        modelAndView.setViewName("info");
        return modelAndView;
    }
    @RequestMapping(value = "/downLoad")
    public void  downLoad(String fileSrc,HttpServletResponse response,HttpServletRequest request) throws UnsupportedEncodingException {
        String fileName = fileSrc.split("_")[1];
        System.out.println(fileName);
        File file = new File(fileSrc);
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            if(request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
                response.setHeader("Content-Disposition","attachment;"+ "filename="+ new
                        String(fileName.getBytes("GBK"),"ISO8859-1"));
            }else{//firefox、chrome、safari、opera
                response.setHeader("Content-Disposition","attachment;"+
                        "filename="+ new String(fileName.getBytes("UTF8"), "ISO8859-1") );
            }
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    @RequestMapping(value = "/updateArticlePage")
    public ModelAndView updateArticlePage(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        UserEntity userEntity= (UserEntity) request.getSession().getAttribute("user");
        List<ArticleEntity> articleEntities;
        if (userEntity.getTypes()==0){
            articleEntities=articleMapper.getAllArticles(null,null,null);
        }else{
            articleEntities=articleMapper.getAllArticles(null,userEntity.getId(),null);
        }
        modelAndView.addObject("types",articleMapper.getTypes());
        modelAndView.addObject("noticeSide",articleMapper.getNoticeSide());
        modelAndView.addObject("articleSide",articleMapper.getArticleSide());
        modelAndView.addObject("articles",articleEntities);
        modelAndView.setViewName("updateArticle");
        return modelAndView;
    }
    @RequestMapping(value = "/deleteArticle")
    public ModelAndView  deleteArticle(String articleId,String typeId){
        System.out.println(articleId);
        System.out.println(articleId+":"+typeId);
        ModelAndView modelAndView=new ModelAndView();
        String path="E:\\upFilePosition\\article\\"+articleId;
        articleMapper.deleteArticle(articleId);
        articleMapper.subType(typeId);
        DeleteFileUtil.deleteDirectory(path);
        modelAndView.setViewName("redirect:/updateArticlePage");
        return modelAndView;
    }
}
