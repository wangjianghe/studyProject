package wjh.graduationproject.model.list.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import wjh.graduationproject.entity.ArticleEntity;
import wjh.graduationproject.entity.ArticleType;
import wjh.graduationproject.model.article.dao.ArticleMapper;

import java.util.List;

/**
 * Created by Administrator on 2019/3/30.
 */
@Controller
public class ListController {
    @Autowired
    ArticleMapper articleMapper;
    @RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView listPage(@RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                 String keyboard,String articleType){
        PageHelper.startPage(pageNum,5);
        List<ArticleEntity> list=articleMapper.getAllArticles(articleType,null,keyboard);
        List<ArticleType> types=articleMapper.getTypes();
        PageInfo<ArticleEntity> pageInfo=new PageInfo<>(list);
        ModelAndView modelAndView=new ModelAndView();
        System.out.println(pageInfo);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("articleType",articleType);
        //侧栏
        modelAndView.addObject("types",types);
        modelAndView.addObject("noticeSide",articleMapper.getNoticeSide());
        modelAndView.addObject("articleSide",articleMapper.getArticleSide());
        modelAndView.setViewName("list");
        return modelAndView;
    }
}
