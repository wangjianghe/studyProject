package wjh.graduationproject.model.user.signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import wjh.graduationproject.common.BuildUUID;
import wjh.graduationproject.common.EmailUtil;
import wjh.graduationproject.common.JudgeNull;
import wjh.graduationproject.common.PasswordEncrypt;
import wjh.graduationproject.entity.UserEntity;
import wjh.graduationproject.model.user.dao.UserMapper;
import wjh.graduationproject.model.user.signup.pojo.ServiceResponseInfo;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * Created by Administrator on 2019/3/30.
 */
@Controller
@RequestMapping("/signUp")
public class SignUpController {
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    UserMapper userMapper;
    @Autowired
    EmailUtil emailUtil;

    @RequestMapping(value = "/",method = {RequestMethod.GET,RequestMethod.POST})
    public String signUpPage(){
        return "signUp";
    }
    @ResponseBody
    @RequestMapping(value = "/validateUsername")
    public Object[] validateUsername(String fieldId, String fieldValue){
        String msg="用户名称可用";
        int result=userMapper.usernameExit(fieldValue.trim());
        if (result<=0){
            return new Object[]{fieldId,true,msg};
        }else{
            msg="用户已存在";
            return new Object[]{fieldId,false,msg};
        }
    }
    @ResponseBody
    @RequestMapping(value = "/validateEmail")
    public Object[] validateEmail(String fieldId, String fieldValue){
        fieldValue=fieldValue.toLowerCase();
        String msg="邮箱可用";
        int result=userMapper.emailExit(fieldValue.trim());
        if (result<=0){
            return new Object[]{fieldId,true,msg};
        }else{
            msg="邮箱已被注册";
            return new Object[]{fieldId,false,msg};
        }
    }
    @RequestMapping(value ="/addUser")
    public ModelAndView validateUser(String username, String email, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException, MessagingException {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("tips");
        if (JudgeNull.IsNull(username)||JudgeNull.IsNull(email)||JudgeNull.IsNull(password)){
            modelAndView.addObject("tips","请填写完数据");
            modelAndView.addObject("redirectUrl","signUp/");
            return modelAndView;
        }
        UserEntity userEntity=new UserEntity();
        String uuid=BuildUUID.getUUID();
        userEntity.setId(uuid);
        userEntity.setEmail(email);
        userEntity.setPassword(PasswordEncrypt.encodeByMd5(password));
        userEntity.setTypes(1);
        userEntity.setStatus(0);
        userEntity.setUserName(username);
        userEntity.setSessionTime(new Date());
        userMapper.insertUser(userEntity);
        emailUtil.sendMail("1026451892@qq.com",
                email,
                "欢迎你注册资料分享网",
                "<html lang='zh-CN'><head ><meta charset='utf-8'>"
                        + "</head><body><h2>欢迎注册资料分享网"+username+"</h2>"
                        +"请点击下面链接对你的邮箱进行激活"
                        + "<a href='http://localhost:8080/signUp/activation?user="+uuid+"'>点击激活</a></body></html>");
        modelAndView.addObject("tips","请到你邮箱激活账户");
        modelAndView.addObject("redirectUrl","index");
        return modelAndView;
    }
    @RequestMapping(value = "/activation")
    public ModelAndView activationUser(String user){
        ModelAndView modelAndView=new ModelAndView();
        userMapper.updateUserActivation(user);
        modelAndView.setViewName("tips");

        modelAndView.addObject("tips","你的账户已激活");
        modelAndView.addObject("redirectUrl","index");
        return modelAndView;
    }
}
