package com.novawind.mourn.service;

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
	
}

