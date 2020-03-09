package com.easymemo.controller;

import com.easymemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 负责user的登录、注册、退出登录
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(String phoneNumber, String checkCode, HttpSession session){
        String kaptcha_session_key = session.getAttribute("KAPTCHA_SESSION_KEY").toString();
        if (userService.checkUser(phoneNumber) != null) {  //手机号已注册
            if (!checkCode.equals(kaptcha_session_key)) {  //验证码错误
                session.setAttribute("msg", "验证码不匹配，请重新输入！");
                return "redirect:/entry/login";
            } else {  //验证码正确，可以直接登录
                session.setAttribute("msg", "已注册，直接登录！");
                session.setAttribute("userAccount", phoneNumber);
                return "redirect:/memo/lookMemo";
            }
        } else {  //手机号未注册
            if (!checkCode.equals(kaptcha_session_key)) {  //验证码错误
                session.setAttribute("msg", "验证码不匹配，请重新输入！");
                return "redirect:/entry/login";
            } else {  //验证码正确，可以直接登录
                userService.addUser(phoneNumber);
                session.setAttribute("msg", "已自动注册，并直接登录！");
                session.setAttribute("userAccount", phoneNumber);
                return "redirect:/entry/addMemo";
            }
        }
    }

    @PostMapping("/register")
    public String register(String phoneNumber, String checkCode, HttpSession session){
        String kaptcha_session_key = session.getAttribute("KAPTCHA_SESSION_KEY").toString();

        if (userService.checkUser(phoneNumber) != null) {  //手机号已注册
            if (!checkCode.equals(kaptcha_session_key)) {  //验证码错误
                session.setAttribute("msg", "验证码不匹配，请重新输入！");
                return "redirect:/entry/register";
            } else {  //验证码正确，可以注册
                session.setAttribute("msg", "手机号已注册，已直接登录！");
                session.setAttribute("userAccount", phoneNumber);
                return "redirect:/memo/lookMemo";
            }
        } else {  //手机号未注册
            if (!checkCode.equals(kaptcha_session_key)) {  //验证码错误
                session.setAttribute("msg", "验证码不匹配，请重新输入！");
                return "redirect:/entry/register";
            } else {  //验证码正确，可以注册
                userService.addUser(phoneNumber);
                session.setAttribute("msg", "注册完成，已直接登录！");
                session.setAttribute("userAccount", phoneNumber);
                return "redirect:/entry/addMemo";
            }
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        if (session.getAttribute("userAccount") != null ) {
            session.removeAttribute("userAccount");
        }
        return "redirect:/entry/login";
    }

}
