package com.easymemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 访问所有的jsp页面（除index.jsp）都要走entry（入口）请求
 */
@Controller
@RequestMapping("/entry")
public class EntryController {

    @GetMapping("/login")
    public String toLogin() {
        return "login";  // login.jsp
    }

    @GetMapping("/register")
    public String toRegister() {
        return "register";  //register.jsp
    }

    @GetMapping("/addMemo")
    public String toAddMemo() {
        return "add-memo"; //add-memo.jsp
    }

    @GetMapping("/lookMemo")
    public String toLookMemo() {
        return "look-memo";  //look-memo.jsp
    }

    @GetMapping("/updateMemo")
    public String toUpdateMemo() {
        return "update-memo";  //update-memo.jsp
    }

}
