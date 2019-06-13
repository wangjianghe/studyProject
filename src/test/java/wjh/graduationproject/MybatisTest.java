package wjh.graduationproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wjh.graduationproject.model.user.dao.UserMapper;

/**
 * Created by Administrator on 2019/4/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void testMybatis(){
        System.out.println(userMapper.test());
    }
}
