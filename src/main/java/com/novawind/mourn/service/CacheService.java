package com.novawind.mourn.service;

import com.novawind.mourn.entity.Admin;
import com.novawind.mourn.repository.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 缓存操作类
 * @author Jeremy Xiong<br>
 * 2017-12-28 16:46
 */
@Service
public class CacheService {
    private final Logger loger = LoggerFactory.getLogger(CacheService.class);

    @Autowired
    private AdminRepository adminRepository;

    @Cacheable(value = "admin", key = "#series")
    public Admin getAdminBySeries(String series){
        Admin admin = adminRepository.findBySeries(series);
        loger.info("已为name为{}的记录缓存 by series: {}", admin.getName(), series);
        return admin;
    }

//    public void updateToken(Long id, String newToken){
//      adminRepository.updateToken(id, newToken);
//    }


}
