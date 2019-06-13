package wjh.graduationproject.model.user.signin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import wjh.graduationproject.common.EmailUtil;
import wjh.graduationproject.common.PasswordEncrypt;
import wjh.graduationproject.entity.UserEntity;
import wjh.graduationproject.model.user.dao.UserMapper;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2019/3/30.
 */
@Controller
public class SignInController {
    @Autowired
    EmailUtil emailUtil;
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/signIn")
    public ModelAndView signInPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("signIn");
        return modelAndView;
    }
    @RequestMapping("/userLogin")
    public ModelAndView userLogin(HttpServletRequest request,String email,String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        ModelAndView modelAndView=new ModelAndView();
        password= PasswordEncrypt.encodeByMd5(password);
        email=email.toLowerCase();
        UserEntity userEntity=userMapper.getLoginUser(email,password);
        if (userEntity==null||userEntity.getId()==null){
            request.setAttribute("loginError","用户名或者密码错误");
            modelAndView.setViewName("signIn");
            return modelAndView;
        }
        System.out.println(userEntity);
        if (userEntity.getStatus()==1){
            request.getSession().setAttribute("user",userEntity);
            modelAndView.setViewName("redirect:/index");
            return modelAndView;
        }
        if (userEntity.getStatus()==-1){
            modelAndView.setViewName("tips");
            modelAndView.addObject("tips","你账户已被冻住 请找管理员");
            modelAndView.addObject("redirectUrl","index");
            return modelAndView;
        }
        modelAndView.setViewName("tips");
        modelAndView.addObject("tips","请到你的注册邮箱激活");
        modelAndView.addObject("redirectUrl","index");
        return modelAndView;
    }
    @RequestMapping(value = "userOut")
    public String userOut(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/index";
    }
}
