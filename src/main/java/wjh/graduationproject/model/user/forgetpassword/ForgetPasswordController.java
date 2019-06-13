package wjh.graduationproject.model.user.forgetpassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import wjh.graduationproject.common.EmailUtil;
import wjh.graduationproject.common.PasswordEncrypt;
import wjh.graduationproject.model.user.dao.UserMapper;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2019/4/14.
 */
@Controller
public class ForgetPasswordController {
    @Autowired
    EmailUtil emailUtil;
    @Autowired
    UserMapper userMapper;
    @RequestMapping(value = "/sendEditPassword")
    public ModelAndView sendEditPassword(String email) throws MessagingException {
        ModelAndView modelAndView=new ModelAndView();
        emailUtil.sendMail("1026451892@qq.com",email,"修改密码",
                "<html lang='zh-CN'><head ><meta charset='utf-8'>"
                        + "</head><body>"
                        +"请点击下面链接对你的的密码进行修改"
                        + "<a href='http://localhost:8080/editPasswordPage?email="+email+"'>点击激活</a></body></html>");
        modelAndView.setViewName("tips");
        modelAndView.addObject("tips","已发送邮件到你邮箱当中");
        modelAndView.addObject("redirectUrl","index");
        return modelAndView;
    }
    @RequestMapping(value = "/forgetPasswordPage")
    public String forgetPasswordPage(){
        return "forgetPassword";
    }
    @RequestMapping(value = "/editPasswordPage")
    public ModelAndView editPasswordPage(String email){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("email",email);
        modelAndView.setViewName("editPassword");
        return modelAndView;
    }
    @RequestMapping(value = "/updatePassword")
    public ModelAndView updatePassword(String email,String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        ModelAndView modelAndView=new ModelAndView();
        password= PasswordEncrypt.encodeByMd5(password);
        userMapper.updatePassword(email,password);
        modelAndView.setViewName("tips");
        modelAndView.addObject("tips","修改密码成功");
        modelAndView.addObject("redirectUrl","index");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/validateEmail")
    public Object[] validateEmail(String fieldId, String fieldValue){
        fieldValue=fieldValue.toLowerCase();
        String msg="账户不存在";
        int result=userMapper.emailExit(fieldValue.trim());
        if (result<=0){
            return new Object[]{fieldId,false,msg};
        }else{
            msg="账户存在";
            return new Object[]{fieldId,true,msg};
        }
    }
}
