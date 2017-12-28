package com.novawind.mourn.service;

import com.novawind.mourn.constant.Constants;
import com.novawind.mourn.constant.ResponseCode;
import com.novawind.mourn.dto.AdminAccessDto;
import com.novawind.mourn.entity.Admin;
import com.novawind.mourn.repository.AdminRepository;
import com.novawind.mourn.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
*  
* @author Jeremy Xiong<br>
* 2017-11-30 10:09:11
*/
@Service
public class AdminService {
	private final Logger loger = LoggerFactory.getLogger(AdminService.class);
	@Autowired
	private CacheService cacheService;
	@Autowired
	private AdminRepository adminRepository;

	public Admin getAdmin(Long id){

		return adminRepository.findOne(id);
	}

	public AdminAccessDto checkUser(Admin admin, String sessionId, boolean rememberMe){
		AdminAccessDto dto = new AdminAccessDto();
		dto.setCode(ResponseCode.BAD_NAME_PWD.getCode());
		Admin db = adminRepository.findByName(admin.getName());
		//admin account not exist
		if(db == null){
			return dto;
		}
		String input = MD5Util.md5Upper(admin.getPassword() + db.getSalt());
		//error admin password
		if(!db.getPassword().equals(input)){
			return dto;
		}

		String token = MD5Util.md5Upper(sessionId + db.getName() + db.getSalt());
		String series = Constants.getSeries();
		//增加2s 完成请求
		Long expireTime = System.currentTimeMillis() + 2 * 1000;
		//if rememberMe is on, set expireTime = currentMills + 30days in mills
		if(rememberMe){
			expireTime = expireTime + Constants.ONE_DAY_IN_MILLS * Constants.AUTO_LOGIN_KEEP_DAYS;
		}
		adminRepository.updateTokenAndSeries(db.getId(), token, series, expireTime);
		dto.setToken(token);
		dto.setSeries(series);
		dto.setCode(ResponseCode.SUCCESS.getCode());

		return dto;
	}

	public AdminAccessDto checkTokenAndSeries(HttpServletRequest request){
		AdminAccessDto dto = new AdminAccessDto();
		dto.setResponseCode(ResponseCode.COOKIE_DISABLED);

		Map<String, String> cookieMap = cookieMap(request);
		if(cookieMap == null){
			dto.setResponseCode(null);
			loger.info("cookie被禁用或被删除");
			return dto;
		}
		dto.setResponseCode(ResponseCode.BAD_TOKEN_OR_SERIES);
		String token = cookieMap.get(Constants.ACCESS_TOKEN_KEY);
		String series = cookieMap.get(Constants.ACCESS_SERIES_KEY);
		if(token == null || series == null){
			loger.info("cookie不存在有效token和series");
			return dto;
		}
		Admin ts = cacheService.getAdminBySeries(series);
		//series不存在，未曾登录，跳转login
		if(ts == null) {
			loger.info("series:{}不存在", series);
			return dto;
		}
		//token不一致，cookie被盗用（token每次登录都会更换）
		if(!token.equals(ts.getToken())) {
			loger.info("series:{}，token不匹配", series);
			return dto;
		}
		//token过期 or 未设置rememberMe功能 跳转login
		if(ts.getExpireTime() <= System.currentTimeMillis()) {
			loger.info("token不在有效期内");
			return dto;
		}
		//验证通过 更换token
		String newToken = MD5Util.md5Upper(request.getSession().getId() + ts.getName() + ts.getSalt());
		ts.setToken(newToken);
		adminRepository.updateToken(ts.getId(), newToken);
		loger.info("验证通过，更换token为{}", newToken);

		dto.setToken(newToken);
		dto.setName(ts.getName());
		dto.setResponseCode(ResponseCode.SUCCESS);

		return dto;
	}

	private static Map<String, String> cookieMap(HttpServletRequest request){
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

	public boolean logout(String name){
		int a = adminRepository.invalidToken(name);
		return a > 0;
	}

}

