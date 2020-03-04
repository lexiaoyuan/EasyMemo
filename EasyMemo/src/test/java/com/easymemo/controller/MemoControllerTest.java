package com.easymemo.controller;

import com.easymemo.pojo.Memo;
import com.easymemo.service.MemoServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MemoControllerTest {
    @Test
    public void lookMemoTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MemoServiceImpl memoServiceImpl = context.getBean("memoServiceImpl", MemoServiceImpl.class);
        List<Memo> memoList = memoServiceImpl.lookMemo("15897677961");
        for (Memo memo : memoList) {
            System.out.println(memo);
        }
    }
}
