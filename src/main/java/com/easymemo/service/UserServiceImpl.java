package com.easymemo.service;

import com.easymemo.dao.UserMapper;
import com.easymemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int addUser(String userAccount) {
        return userMapper.addUser(userAccount);
    }

    public User checkUser(String userAccount) {
        return userMapper.checkUser(userAccount);
    }

    public int deleteUser(String userAccount) {
        return userMapper.deleteUser(userAccount);
    }
}
