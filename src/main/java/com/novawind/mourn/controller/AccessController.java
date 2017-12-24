package com.novawind.mourn.controller;

import com.novawind.mourn.constant.Constants;
import com.novawind.mourn.constant.ResponseCode;
import com.novawind.mourn.entity.Admin;
import com.novawind.mourn.service.AdminService;
import com.novawind.mourn.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
*  
* @author Jeremy Xiong<br>
* 2017-12-07 09:49:00
*/
@RequestMapping("/access")
@Controller
public class AccessController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/login")
	public String login(){
		
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(){
		
		return "logout";
	}
	@RequestMapping(value="/checkUser", method = RequestMethod.POST)
	@ResponseBody
	public String checkUser(Admin admin,@RequestParam boolean rememberMe, HttpSession session){

		return adminService.checkUser(admin, session.getId());
	}
}

