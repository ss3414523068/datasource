package com.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Order(2)
@Component
public class EhCacheUtil implements CommandLineRunner {

    private static Log logger = LogFactory.getLog(EhCacheUtil.class);

    @Autowired
    private CacheManager cacheManager;

    @Override
    public void run(String... args) {
        Cache cache = cacheManager.getCache("user");
        Map map = new LinkedHashMap();
        map.put("key1", "value1");
        cache.put(new Element("map", map));
    }

    @Scheduled(cron = "*/30 * * * * *")
    public void cron() {
        Cache cache = cacheManager.getCache("user");
        try {
            cache.acquireWriteLockOnKey("map");
            logger.info("EhCacheUtil update");
            TimeUnit.SECONDS.sleep(5);
            Map map = new LinkedHashMap();
            map.put("key2", "value2");
            cache.put(new Element("map", map));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            cache.releaseWriteLockOnKey("map");
        }
    }

}
