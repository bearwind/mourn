package com.novawind.mourn.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jeremy Xiong<br>
 * 17-12-13 上午9:55
 * 2017-12-13 09:55
 */
@Controller
@RequestMapping("/error")
public class BaseErrorController implements ErrorController{


    @Override
    public String getErrorPath () {
        System.out.println("error!!");
        return "error";
    }
    @RequestMapping
    public String error(Model m){
        m.addAttribute("error", "抱歉，出错了！");
        return getErrorPath();
    }
}
