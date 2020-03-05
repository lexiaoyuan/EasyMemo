package com.easymemo.controller;

import com.easymemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(String phoneNumber, String checkCode, HttpSession session){

        if (userService.checkUser(phoneNumber) != null) {  //手机号已注册
            if (!checkCode.equals("123456")) {  //验证码错误
                session.setAttribute("msg", "验证码错误，请重新输入！");
                return "redirect:/entry/login";
            } else {  //验证码正确，可以直接登录
                return "memo";  //memo.jsp
            }
        } else {  //手机号未注册
            session.setAttribute("msg", "手机号未注册，请先注册！");
            return "redirect:/entry/register";
        }
    }

    @PostMapping("/register")
    public String register(String phoneNumber, String checkCode, HttpSession session){
        if (userService.checkUser(phoneNumber) != null) {  //手机号已注册
            session.setAttribute("msg", "手机号已注册，请直接登录！");
        } else {  //手机号未注册
            if (!checkCode.equals("654321")) {  //验证码错误
                session.setAttribute("msg", "验证码错误，请重新输入！");
                return "redirect:/entry/register";
            } else {  //验证码正确，可以注册
                userService.addUser(phoneNumber);
                session.setAttribute("msg", "注册成功，请直接登录！");
            }
        }
        return "redirect:/entry/login";
    }
}
