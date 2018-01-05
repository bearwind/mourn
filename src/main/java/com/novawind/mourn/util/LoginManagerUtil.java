package com.novawind.mourn.util;

import com.novawind.mourn.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jeremy Xiong<br>
 * 2018-01-04 16:37
 */
public class LoginManagerUtil {
    private static final Logger loger = LoggerFactory.getLogger(LoginManagerUtil.class);
    public static Map<String, String> cookieMap(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies == null){
            return null;
        }
        Map<String, String> map = new HashMap<>();
        for (Cookie cookie : cookies) {
            map.put(cookie.getName(), cookie.getValue());
        }
        return map;
    }

    public static boolean isAjax(HttpServletRequest request){

        return "XMLHttpRequest".equals(request.getHeader("x-requested-with"));
    }

    public static Long getIdByDecodeSeriesInCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies == null){
            return null;
        }
        for (Cookie cookie : cookies) {
           if(Constants.ACCESS_SERIES_KEY.equals(cookie.getName())){
               String series = cookie.getValue();
               try {
                   series = URLDecoder.decode(series, Constants.UTF8);
               } catch (UnsupportedEncodingException e) {
                   loger.error("series:{} url解码失败", series);
                   return null;
               }
               return Long.parseLong(series.split(Constants.COLON)[0]);
           }
        }
        return null;
    }

}
