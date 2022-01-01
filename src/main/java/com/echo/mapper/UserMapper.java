package com.echo.mapper;

import com.echo.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<UserInfo> getAllUsers();

    public void deleteUser(@Param("userId") Long id);

    public UserInfo findUpdateInfoById(@Param("userId") Long id);

    public void updateUser(UserInfo userInfo);

    public void resetWorkType(@Param("newType") String newType,@Param("workType") String workType);

    public UserInfo getUserByPhoneNum(@Param("phoneNumber") String phoneNumber);

    public void resetUserScore();
}
