package com.novawind.mourn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
*  
* @author Jeremy Xiong<br>
* 2017-12-07 09:49:00
*/
@RequestMapping("/access")
@Controller
public class AccessController {
	
	
	@RequestMapping("/login")
	public String login(){
		
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(){
		
		return "logout";
	}
}

