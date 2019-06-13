package wjh.graduationproject.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Administrator on 2019/4/2.
 */
@Component
public class EmailUtil {
    @Autowired
    private JavaMailSender mailSender;
    public void sendMail(String fromBody,String toBody,String topic,String content) throws MessagingException {
        Properties prop=new Properties();
        prop.setProperty("mail.host", "smtp.sohu.com");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        Session session=Session.getInstance(prop);
        session.setDebug(true);
        MimeMessage message=new MimeMessage(session);
        message.setFrom(fromBody);
        message.setRecipients(Message.RecipientType.TO,toBody);
        message.setSubject(topic);
        message.setContent(content,"text/html;charset=UTF-8");
        mailSender.send(message);
    }
}
