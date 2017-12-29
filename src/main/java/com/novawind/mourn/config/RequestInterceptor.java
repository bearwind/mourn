package com.novawind.mourn.config;

import com.novawind.mourn.constant.Constants;
import com.novawind.mourn.constant.ResponseCode;
import com.novawind.mourn.dto.AdminAccessDto;
import com.novawind.mourn.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Jeremy Xiong<br>
 * 2017-12-22 17:57
 */
@Configuration
public class RequestInterceptor extends HandlerInterceptorAdapter{
    @Autowired
    private AdminService adminService;

    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //0.通过点击登录按钮登录的session != null
        HttpSession session = request.getSession();
        if(session.getAttribute(Constants.SESSION_KEY) != null){
            return true;
        }
        //session失效后操作:
        //1.判断token和series是否合法
        AdminAccessDto verify = adminService.checkTokenAndSeries(request);
        boolean access = verify.getResponseCode() == ResponseCode.SUCCESS;
        if(!access){
            //2.判断是否为ajax请求
            if(isAjax(request)) {
                response.setHeader("sessionStatus", "timeout");
            //3.非ajax请求
            } else {
                response.sendRedirect("../access/login?deny=" + verify.getResponseCode().getCode());
            }
            return false;
        }
        //4.合法，则设置新token及session
        Cookie cookie = new Cookie(Constants.ACCESS_TOKEN_KEY, verify.getToken());
        cookie.setMaxAge(Constants.ONE_DAY_IN_SECONDS * Constants.AUTO_LOGIN_KEEP_DAYS);
        cookie.setPath("/");
        response.addCookie(cookie);

        session.setAttribute(Constants.SESSION_KEY, verify.getName());
        session.setMaxInactiveInterval(Constants.SESSION_INVALID_TIME);

        return true;
    }

    private boolean isAjax(HttpServletRequest request){

        return request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equals("XMLHttpRequest");
    }

}
