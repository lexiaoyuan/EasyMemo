package com.easymemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/entry")
public class InterceptorController {

    @GetMapping("/login")
    public String toLogin() {
        return "login";  // login.jsp
    }

    @GetMapping("/register")
    public String toRegister() {
        return "register";  //register.jsp
    }

}
