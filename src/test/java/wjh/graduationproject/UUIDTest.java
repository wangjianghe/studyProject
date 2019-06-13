package wjh.graduationproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wjh.graduationproject.common.BuildUUID;

/**
 * Created by Administrator on 2019/4/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UUIDTest {
    @Test
    public void testUUID(){
        System.out.println(BuildUUID.getUUID());
    }
}
