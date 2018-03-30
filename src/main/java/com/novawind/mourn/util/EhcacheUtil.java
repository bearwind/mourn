package com.novawind.mourn.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Component;

/**
 * @author Jeremy Xiong<br>
 * 2018-03-20 14:21
 */
@Component
public class EhcacheUtil {

    @Autowired
    private EhCacheCacheManager ehCacheCacheManager;


    @SuppressWarnings("unchecked")
    public <T> T getCacheValue(String cacheName, Object key, Class<T> clazz){
        Cache cache = ehCacheCacheManager.getCacheManager().getCache(cacheName);
        Element e;
        if(cache != null && (e = cache.get(key)) != null){
            return (T)e.getObjectValue();
        }
        return null;
    }

}
