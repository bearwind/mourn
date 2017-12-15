package com.novawind.mourn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.novawind.mourn.service.AdminService;

/**
*  
* @author Jeremy Xiong<br>
* 2017-11-27 17:05:44
*/
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/index")
	public String index(Model m){
		
		return "index";
	}
	@RequestMapping("/frame")
	public String frame(){
		return "frame";
	}
	
	@RequestMapping("/auth")
	public String auth(){
		
		return "auth";
	}
	
	@RequestMapping("/get")
	@ResponseBody
	public String get(@RequestParam Long id){
		
		return adminService.getAdmin(id).toString();
	}
	

}

