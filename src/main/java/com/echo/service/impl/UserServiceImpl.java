package com.echo.service.impl;

import com.echo.mapper.UserMapper;
import com.echo.pojo.UserInfo;
import com.echo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserInfo> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public void deleteUser(Long id) {
        userMapper.deleteUser(id);
    }

    @Override
    public UserInfo findUpdateInfoById(Long id) {
        return userMapper.findUpdateInfoById(id);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        userMapper.updateUser(userInfo);
    }
    @Override
    public UserInfo getUserByPhoneNum(String phoneNumber){
        return userMapper.getUserByPhoneNum(phoneNumber);
    }
}
