package wjh.graduationproject.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by Administrator on 2019/4/2.
 */
public class PasswordEncrypt {
    public static String encodeByMd5(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5=MessageDigest.getInstance("MD5");
        Base64.Encoder base64Encoder=Base64.getEncoder();
        String EncryptPs= base64Encoder.encodeToString(md5.digest(password.getBytes("utf-8")));
        EncryptPs=EncryptPs.replace("=","");
        return EncryptPs;
    };
}
