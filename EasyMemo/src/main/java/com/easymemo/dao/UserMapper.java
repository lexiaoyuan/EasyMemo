package com.easymemo.dao;

import com.easymemo.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int addUser(@Param("userAccount") String userAccount);
    User checkUser(@Param("userAccount") String userAccount);
}
