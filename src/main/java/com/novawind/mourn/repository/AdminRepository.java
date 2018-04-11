package com.novawind.mourn.repository;



import com.novawind.mourn.entity.Admin;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
*  
* @author Jeremy Xiong<br>
* 2017-11-30 09:38:13
*/
@Transactional
public interface AdminRepository extends CrudRepository<Admin, Long>{

    Admin findByName(String name);

    Admin findBySeries(String series);

    @Modifying
    @Query(value = "update Admin a set a.expireTime = 0 where a.id = ?1")
    int invalidToken(Long id);

}

