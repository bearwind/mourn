package com.novawind.mourn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;

/**
 * @author Jeremy Xiong<br>
 * 17-12-13 上午9:55
 * 2017-12-13 09:55
 */
@Controller
public class BaseErrorController implements ErrorController{
    private final Logger logger = LoggerFactory.getLogger(BaseErrorController.class);
    @Autowired
    private ErrorAttributes errorAttributes;
    @Override
    public String getErrorPath () {
        return "error";
    }
    @RequestMapping("/error")
    public String error(Model m, HttpServletRequest request){
        m.addAttribute("httpStatus", getStatus(request));

        return getErrorPath();
    }

    private int getStatus(HttpServletRequest request){
        Map<String, Object> map = errorAttributes.getErrorAttributes(new ServletRequestAttributes(request), false);
        if(map != null){
            logger.error("httpStatus={}, path={}", map.get("status"), map.get("path"));
            return (int) map.get("status");
        }
        return 0;
    }
}
