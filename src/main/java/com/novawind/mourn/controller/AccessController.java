package com.novawind.mourn.controller;

import com.novawind.mourn.entity.Admin;
import com.novawind.mourn.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping("/checkUser")
	@ResponseBody
	public String checkUser(Admin admin){

		return adminService.checkUser(admin).getCode();
	}
}

