package com.novawind.mourn.controller;

import com.novawind.mourn.constant.Constants;
import com.novawind.mourn.constant.ResponseCode;
import com.novawind.mourn.dto.AdminAccessDto;
import com.novawind.mourn.entity.Admin;
import com.novawind.mourn.service.AdminService;
import com.novawind.mourn.util.JsonUtil;
import com.novawind.mourn.util.LoginManagerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String login(@RequestParam(value = "deny", required = false) String denyCode, Model model){
		if(denyCode != null){
			model.addAttribute("deny", ResponseCode.getMsgByCode(denyCode) + "，错误代码：" + denyCode);
		}

		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(Model model, HttpServletRequest request){
		model.addAttribute("deny",
				adminService.logout(LoginManagerUtil.getIdByDecodeSeriesInCookie(request)) ?
						ResponseCode.LOGOUT.getMsg() : ResponseCode.FAIL.getMsg());
		return "login";
	}
	@RequestMapping(value="/checkUser", method = RequestMethod.POST)
	@ResponseBody
	public String checkUser(Admin admin,@RequestParam boolean rememberMe, HttpSession session){
		AdminAccessDto dto = adminService.checkUser(admin, session.getId(), rememberMe);

		return JsonUtil.toJson(dto);
	}
}

