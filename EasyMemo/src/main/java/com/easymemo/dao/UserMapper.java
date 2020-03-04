package com.easymemo.dao;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int addUser(@Param("userAccount") String userAccount);
}
