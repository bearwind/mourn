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
    @Query(value = "update admin set token = ?2, series = ?3, expire_time = ?4 where id = ?1", nativeQuery = true)
    void updateTokenAndSeries(Long id, String token, String series, Long expireTime);

    @Modifying
    @Query(value = "update admin set token = ?2 where id = ?1", nativeQuery = true)
    void updateToken(Long id, String token);

    @Modifying
    @Query(value = "update admin set expire_time = 0 where id = ?1", nativeQuery = true)
    int invalidToken(Long id);

}

