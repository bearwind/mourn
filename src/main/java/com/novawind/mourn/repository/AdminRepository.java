package com.novawind.mourn.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.novawind.mourn.entity.Admin;

/**
*  
* @author Jeremy Xiong<br>
* 2017-11-30 09:38:13
*/
@Transactional
public interface AdminRepository extends CrudRepository<Admin, Long>{

    Admin findByName(String name);
	
}

