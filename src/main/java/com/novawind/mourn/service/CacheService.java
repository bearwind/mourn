package com.novawind.mourn.service;

import com.novawind.mourn.entity.Admin;
import com.novawind.mourn.repository.AdminRepository;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

/**
 * 缓存操作类
 * @author Jeremy Xiong<br>
 * 2017-12-28 16:46
 */
@Service
@CacheConfig(cacheNames = "admin")
public class CacheService {
    private final Logger loger = LoggerFactory.getLogger(CacheService.class);

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private EhCacheCacheManager ehCacheCacheManager;

    @Cacheable(key = "#id", unless = "#result == null")
    public Admin checkSeriesById (Long id){
        Admin admin = adminRepository.findOne(id);
        if(admin != null) loger.info("已为id为{}的记录缓存 by series: {}", id, admin.getSeries());
        return admin;
    }
    @CachePut(key = "#result.getId()")
    public Admin updateTokenAndSeries(Admin admin, String token, String series, Long expireTime){
        adminRepository.updateTokenAndSeries(admin.getId(), token, series, expireTime);
        admin.setToken(token);
        admin.setSeries(series);
        admin.setExpireTime(expireTime);

        loger.info("已为id为{}的记录缓存 by update token & series: {}", admin.getId(), series);
        return admin;
    }
    @CacheEvict
    public int invalidToken(Long id){
        loger.info("已清除id为{}的记录缓存 clear id cache for log out", id);
        return adminRepository.invalidToken(id);
    }


    public Admin getAdminCacheById(Long key){
        Cache cache = ehCacheCacheManager.getCacheManager().getCache("admin");
        Element e;
        if(cache != null && (e = cache.get(key)) != null){
            return (Admin)e.getObjectValue();
        }
        return null;
    }


}
