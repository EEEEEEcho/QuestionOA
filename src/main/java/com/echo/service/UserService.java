package com.echo.service;

import com.echo.pojo.UserInfo;

import java.util.List;

public interface UserService {
    public List<UserInfo> getAllUsers();

    public void deleteUser(Long id);

    public UserInfo findUpdateInfoById(Long id);

    public void updateUser(UserInfo userInfo);

    public UserInfo getUserByPhoneNum(String phoneNumber);
}
