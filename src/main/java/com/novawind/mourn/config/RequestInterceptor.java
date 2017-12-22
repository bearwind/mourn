package com.novawind.mourn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jeremy Xiong<br>
 * 2017-12-22 17:57
 */
@Configuration
public class RequestInterceptor extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("放行!");
        return true;
    }
}
