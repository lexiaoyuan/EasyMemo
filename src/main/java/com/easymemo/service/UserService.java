package com.easymemo.service;

import com.easymemo.pojo.User;

public interface UserService {
    int addUser(String userAccount);
    User checkUser(String userAccount);
    int deleteUser(String userAccount);
}
