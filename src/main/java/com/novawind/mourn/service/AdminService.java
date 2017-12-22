package com.novawind.mourn.service;

import com.novawind.mourn.constant.ResponseCode;
import com.novawind.mourn.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novawind.mourn.entity.Admin;
import com.novawind.mourn.repository.AdminRepository;

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

	public ResponseCode checkUser(Admin admin){
		Admin db = adminRepository.findByName(admin.getName());
		if(db == null){
			return ResponseCode.BAD_NAME_PWD;
		}
		String input = MD5Util.md5Upper(admin.getPassword() + db.getSalt());
		if(!db.getPassword().equals(input)){
			return  ResponseCode.BAD_NAME_PWD;
		}

		return ResponseCode.SUCCESS;
	}
	
}

