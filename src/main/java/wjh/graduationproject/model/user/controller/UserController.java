package wjh.graduationproject.model.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import wjh.graduationproject.common.EmailUtil;
import wjh.graduationproject.common.JudgeNull;
import wjh.graduationproject.entity.UserEntity;
import wjh.graduationproject.model.article.dao.ArticleMapper;
import wjh.graduationproject.model.user.dao.UserMapper;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by Administrator on 2019/5/28.
 */
@Controller
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    EmailUtil emailUtil;
    @Autowired
    ArticleMapper articleMapper;
    @RequestMapping(value = "/updateUserPage")
    public ModelAndView updateUserPage(){
        ModelAndView modelAndView=new ModelAndView();
        List<UserEntity> userEntities=userMapper.getAllUsers();
        modelAndView.addObject("types",articleMapper.getTypes());
        modelAndView.addObject("noticeSide",articleMapper.getNoticeSide());
        modelAndView.addObject("articleSide",articleMapper.getArticleSide());
        modelAndView.addObject("users",userEntities);
        modelAndView.setViewName("updateUser");
        return modelAndView;
    }
    @RequestMapping(value = "/updateUser")
    public ModelAndView updateUser(String email,int updateStatus,String userId,String username,String uuid) throws MessagingException {
        ModelAndView modelAndView=new ModelAndView();
        if (JudgeNull.isNotNull(email)){
            emailUtil.sendMail("1026451892@qq.com",
                    email,
                    "欢迎你注册资料分享网",
                    "<html lang='zh-CN'><head ><meta charset='utf-8'>"
                            + "</head><body><h2>欢迎注册资料分享网"+username+"</h2>"
                            +"请点击下面链接对你的邮箱进行激活"
                            + "<a href='http://localhost:8080/signUp/activation?user="+uuid+"'>点击激活</a></body></html>");
            modelAndView.addObject("tips","请到你邮箱激活账户");
            modelAndView.addObject("redirectUrl","index");
            modelAndView.setViewName("tips");
            return modelAndView;
        }else{
            userMapper.updateUserStatus(updateStatus,userId);
            modelAndView.addObject("tips","用户状态已被改变");
            modelAndView.addObject("redirectUrl","index");
            modelAndView.setViewName("tips");
            return modelAndView;
        }
    }

}
