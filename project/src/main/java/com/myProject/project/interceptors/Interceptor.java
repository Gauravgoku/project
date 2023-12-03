package com.sctpl.admin.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;




@Component
public class Interceptor implements HandlerInterceptor {

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//
//
//        userLoginDto user = new userLoginDto();
//
//         if (user.getUserName() != null && user.getPassword() != null &&
//                user.getUserName().equals(userName) && user.getPassword().equals(password)) {
//                response.sendRedirect("/api/login/match");
//        }
//      return true;
//    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("Post Handle method is Calling");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {

        System.out.println("Request and Response is completed");
    }
    }
