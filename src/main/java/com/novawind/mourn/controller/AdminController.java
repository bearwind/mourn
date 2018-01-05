package com.novawind.mourn.controller;

import com.novawind.mourn.service.AdminService;
import com.novawind.mourn.service.CacheService;
import com.novawind.mourn.util.LoginManagerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
*  
* @author Jeremy Xiong<br>
* 2017-11-27 17:05:44
*/
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService;
	@Autowired
	private EhCacheCacheManager ehCacheCacheManager;
	@Autowired
	private CacheService cacheService;

	@RequestMapping("/index")
	public String index(Model m){
		
		return "index";
	}
	@RequestMapping("/frame")
	public String frame(HttpServletRequest request){
		Long id = LoginManagerUtil.getIdByDecodeSeriesInCookie(request);
		if(id != null){
			request.setAttribute("adminName", cacheService.getAdminCacheById(id).getName());
		}
		return "frame";
	}
	
	@RequestMapping("/auth")
	public String auth(){
		
		return "auth";
	}
	
	@RequestMapping("/get")
	@ResponseBody
	public String get(@RequestParam String id){
		if(id.equals("0")){
			return ehCacheCacheManager.getCacheManager().getCache("admin").getKeys().toString();
		}
		return cacheService.checkSeriesById(Long.parseLong(id)).toString();
	}
	

}

