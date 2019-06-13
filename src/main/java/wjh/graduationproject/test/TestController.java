package wjh.graduationproject.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2019/3/25.
 */
@Controller
public class TestController {
    @RequestMapping("/")
    public String test(){
        return "index";
    };
}
