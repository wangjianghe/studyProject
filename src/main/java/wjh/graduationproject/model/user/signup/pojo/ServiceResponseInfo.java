package wjh.graduationproject.model.user.signup.pojo;

import wjh.graduationproject.constants.SysConstant;

/**
 * Created by Administrator on 2019/4/3.
 */
public class ServiceResponseInfo {
    private int result;
    private String status;
    private String message;
    private Object data;
    public ServiceResponseInfo(int result, String status, String message, Object data) {
        this.result = result;
        this.message = message;
        this.status = status;
        this.data = data;
    }
    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static ServiceResponseInfo getSuccessInfo(String message,Object data){
        if(message==null) message="Success";
        return new ServiceResponseInfo(SysConstant.SERVICE_RESULT_SUCCESS,null,message,data);
    }
    public static ServiceResponseInfo getSuccessInfo(String message){
        if(message==null) message="Success";
        return new ServiceResponseInfo(SysConstant.SERVICE_RESULT_SUCCESS,null,message,null);
    }
    public static ServiceResponseInfo getErrorInfo(String message,Object data){
        if(message==null) message="I'm sorry!There is an error,Please contact your administrator!";
        return new ServiceResponseInfo(SysConstant.SERVICE_RESULT_ERROR,null,message,data);
    }
    public static ServiceResponseInfo getErrorInfo(String message){
        if(message==null) message="I'm sorry!There is an error,Please contact your administrator!";
        return new ServiceResponseInfo(SysConstant.SERVICE_RESULT_ERROR,null,message,null);
    }
}
