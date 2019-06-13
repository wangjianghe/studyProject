package wjh.graduationproject.common;

import java.util.UUID;

/**
 * Created by Administrator on 2019/4/7.
 */
public class BuildUUID {
    public static String getUUID(){
        String uuid=UUID.randomUUID().toString().replace("-","").toLowerCase();
        return uuid;
    }
}
