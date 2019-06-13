package wjh.graduationproject.common;

/**
 * Created by Administrator on 2019/4/8.
 */
public class JudgeNull {
    public static boolean IsNull(String targetValue){
        return targetValue==null||targetValue.length()==0||targetValue.trim().length()==0;
    }
    public static boolean isNotNull(String targetValue){
        return !IsNull(targetValue);
    }
}
