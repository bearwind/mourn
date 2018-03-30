package com.novawind.mourn.config;

import com.novawind.mourn.constant.Constants;
import com.novawind.mourn.constant.ResponseCode;
import com.novawind.mourn.dto.AdminAccessDto;
import com.novawind.mourn.entity.Admin;
import com.novawind.mourn.service.AdminService;
import com.novawind.mourn.service.CacheService;
import com.novawind.mourn.util.LoginManagerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.Map;

/**
 * @author Jeremy Xiong<br>
 * 2017-12-22 17:57
 */
@Configuration
public class RequestInterceptor extends HandlerInterceptorAdapter{
    @Autowired
    private MournConfig mournConfig;
    @Autowired
    private AdminService adminService;
    @Autowired
    private CacheService cacheService;

    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //0.获取cache
        Map<String, String> cookieMap = LoginManagerUtil.cookieMap(request);
        if(cookieMap != null){
            String series = cookieMap.get(Constants.ACCESS_SERIES_KEY);
            if(StringUtils.hasText(series)){
                    Admin cache = cacheService.getAdminCacheById(
                        Long.parseLong(URLDecoder.decode(series, Constants.UTF8).split(Constants.COLON)[0]));
                if(cache != null) return true;
            }
        }

        //cache不存在(替代session)
        //1.判断token和series是否合法
        AdminAccessDto verify = adminService.checkTokenAndSeries(request);
        boolean access = verify.getResponseCode() == ResponseCode.SUCCESS;
        if(!access){
            //2.判断是否为ajax请求
            if(LoginManagerUtil.isAjax(request)) {
                response.setHeader("sessionStatus", "timeout");
            //3.非ajax请求
            } else {
                response.sendRedirect("../access/login?deny=" + verify.getResponseCode().getCode());
            }
            return false;
        }
        //4.合法，则设置新token及session
        Cookie cookie = new Cookie(Constants.ACCESS_TOKEN_KEY, verify.getToken());
        cookie.setMaxAge(Constants.ONE_DAY_IN_SECONDS * mournConfig.getAutoLoginKeepDays());
        cookie.setPath("/");
        response.addCookie(cookie);

        return true;
    }

}
