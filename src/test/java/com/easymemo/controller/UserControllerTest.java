package com.easymemo.controller;

import com.easymemo.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserControllerTest {
    @Test
    public void lookMemoTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userServiceImpl = context.getBean("userServiceImpl", UserServiceImpl.class);
        int i = userServiceImpl.addUser("15877022895");
        if (i>0) {
            System.out.println("userServiceImpl.addUser==>注册成功！");
        }

    }
}
