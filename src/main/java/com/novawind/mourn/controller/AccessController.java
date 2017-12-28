package com.novawind.mourn.controller;

import com.novawind.mourn.constant.Constants;
import com.novawind.mourn.constant.ResponseCode;
import com.novawind.mourn.dto.AdminAccessDto;
import com.novawind.mourn.entity.Admin;
import com.novawind.mourn.service.AdminService;
import com.novawind.mourn.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String logout(HttpSession session, Model model){
		if(session != null){
			Object name = session.getAttribute(Constants.SESSION_KEY);
			session.invalidate();
			if(name != null){
				String out = (String)name;
				model.addAttribute("deny", adminService.logout(out) ? ResponseCode.LOGOUT.getMsg() : ResponseCode.FAIL.getMsg());
			}
		}
		return "login";
	}
	@RequestMapping(value="/checkUser", method = RequestMethod.POST)
	@ResponseBody
	public String checkUser(Admin admin,@RequestParam boolean rememberMe, HttpSession session){
		AdminAccessDto dto = adminService.checkUser(admin, session.getId(), rememberMe);
		if(ResponseCode.SUCCESS.getCode().equals(dto.getCode())){
			session.setAttribute(Constants.SESSION_KEY, admin.getName());
			session.setMaxInactiveInterval(Constants.SESSION_INVALID_TIME);
		}

		return JsonUtil.toJson(dto);
	}
}

