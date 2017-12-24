package com.novawind.mourn.service;

import com.novawind.mourn.constant.Constants;
import com.novawind.mourn.entity.Admin;
import com.novawind.mourn.repository.AdminRepository;
import com.novawind.mourn.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*  
* @author Jeremy Xiong<br>
* 2017-11-30 10:09:11
*/
@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	
	public Admin getAdmin(Long id){
		
		return adminRepository.findOne(id);
	}

	public String checkUser(Admin admin, String sessionId){
		Admin db = adminRepository.findByName(admin.getName());
		if(db == null){
			return null;
		}
		String input = MD5Util.md5Upper(admin.getPassword() + db.getSalt());
		if(!db.getPassword().equals(input)){
			return null;
		}
		String token = MD5Util.md5Upper(sessionId + db.getName() + db.getSalt());
		String series = Constants.getSeries();
		adminRepository.updateTokenAndSeries(db.getId(), token, series);

		return null;
	}

}

