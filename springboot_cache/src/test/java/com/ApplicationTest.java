package com;

import com.mapper.UserMapper;
import com.model.User;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CacheManager cacheManager;

    /* 缓存交由Spring管理 */
    @Test
    public void test() {
        User user1 = userMapper.selectByPrimaryKey(1);
        System.out.println("result1");

        /* 引入Ehcache后CacheManager为EhcacheCacheManager */
        Cache cache = cacheManager.getCache("user");

        /* 第二次查询时不会打印SQL */
        User user2 = userMapper.selectByPrimaryKey(1);
        System.out.println("result2");
    }

    /* 手动添加/获取 */
//    @Test
    public void test2() {
        Cache cache = cacheManager.getCache("user");
        cache.put("key", "value");
        test3();
    }

    public void test3() {
        Cache cache = cacheManager.getCache("user");
        System.out.println(cache.get("key", String.class));
    }

    /* 直接使用Ehcache（手动构造cacheManager） */
//    @Test
    public void test4() {
        org.ehcache.CacheManager cacheManager = CacheManagerBuilder
                .newCacheManagerBuilder()
                .withCache("user", CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(100).offheap(1, MemoryUnit.MB)))
                .build(true);
        org.ehcache.Cache<Long, String> cache = cacheManager.getCache("user", Long.class, String.class);
        cache.put(1L, "name1");
        System.out.println(cache.get(1L));
    }

}
