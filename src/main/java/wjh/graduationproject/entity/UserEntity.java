package wjh.graduationproject.entity;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Administrator on 2019/4/7.
 */
public class UserEntity {
    private String id;
    private String userName;
    private String password;
    private String email;
    private int status;
    private Date sessionTime;
    /**
     * 0 管理员 1 普通用户
     */
    private int types;
    private Object[] otherData;
    public UserEntity() {
    }

    public UserEntity(String id, String userName, String password, String email, int status, Date sessionTime, int types, Object[] otherData) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.status = status;
        this.sessionTime = sessionTime;
        this.types = types;
        this.otherData = otherData;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTypes() {
        return types;
    }

    public void setTypes(int types) {
        this.types = types;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Date getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(Date sessionTime) {
        this.sessionTime = sessionTime;
    }

    public Object[] getOtherData() {
        return otherData;
    }

    public void setOtherData(Object[] otherData) {
        this.otherData = otherData;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", sessionTime=" + sessionTime +
                ", types=" + types +
                ", otherData=" + Arrays.toString(otherData) +
                '}';
    }
}
