/*
package com.shangxin.demo.config;

import com.shangxin.demo.pojo.Login;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginInterceptor implements HandlerInterceptor {


    //请求处理之前调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws IOException {

        Object admin = request.getSession().getAttribute("admin");
        if(null!=admin ){
            return true;
        }else {
            response.sendRedirect("/index");
            return false;
        }
    }

}*/
