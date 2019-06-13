package wjh.graduationproject;

import wjh.graduationproject.common.PasswordEncrypt;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2019/4/2.
 */
public class CommonTest {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println(PasswordEncrypt.encodeByMd5("admin"));
    }
}
