package wjh.graduationproject.model.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import wjh.graduationproject.entity.UserEntity;

import java.util.List;

/**
 * Created by Administrator on 2019/4/7.
 */
@Mapper
public interface UserMapper {
    public int test();
    public int emailExit(@Param("email") String email);
    public int usernameExit(@Param("userName") String userName);
    public int insertUser(UserEntity userEntity);
    public int updateUserActivation(@Param("uuid") String uuid);
    public UserEntity getLoginUser(@Param("email") String email,@Param("password") String password);
    int updatePassword(@Param("email") String email,@Param("password") String password);
    List<UserEntity> getAllUsers();
    int updateUserStatus(@Param("status") int status,@Param("uuid") String uuid);
}
