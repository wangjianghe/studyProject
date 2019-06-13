package wjh.graduationproject.model.index.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import wjh.graduationproject.entity.ArticleEntity;
import wjh.graduationproject.entity.ArticleType;
import wjh.graduationproject.model.article.dao.ArticleMapper;
import wjh.graduationproject.model.article.service.ArticleService;

import java.util.List;

/**
 * Created by Administrator on 2019/3/30.
 */
@Controller
public class IndexController {
    @Autowired
    ArticleService articleService;
    @Autowired
    ArticleMapper articleMapper;
    @RequestMapping(value = "/",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView defaultPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("redirect:/index");
        return modelAndView;
    }
    @RequestMapping(value = "/index",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView indexPage(){
        ModelAndView modelAndView=new ModelAndView();
        List<ArticleEntity> articles=articleService.getArticlesOrderbyTime();
        PageInfo<ArticleEntity> pageInfo=new PageInfo<>(articles);
        System.out.println(pageInfo);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("notices",articleMapper.getNotices());
        //侧边栏所需要的 重要通知 统计 排行
        modelAndView.addObject("types",articleMapper.getTypes());
        modelAndView.addObject("noticeSide",articleMapper.getNoticeSide());
        modelAndView.addObject("articleSide",articleMapper.getArticleSide());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
