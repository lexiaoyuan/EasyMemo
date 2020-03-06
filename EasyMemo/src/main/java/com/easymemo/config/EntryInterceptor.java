package com.easymemo.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EntryInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String requestURI = request.getRequestURI();

        /*放行*/
        //1. 请求登录、注册
        if (requestURI.contains("login") || requestURI.contains("register")) {
            return true;
        }

        // 2. 登录成功
        if (session.getAttribute("userAccount")!=null) {
            return true;
        }

        // 不能放行就转到登录
        request.getRequestDispatcher("/entry/login").forward(request, response);
        return false;
    }
}
