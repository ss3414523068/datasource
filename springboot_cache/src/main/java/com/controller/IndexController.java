package com.controller;

import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("")
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    /* fixme 一级缓存 */
    @GetMapping("/first")
    public Map<String, Object> first() {
        userMapper.selectOne(1);
        userMapper.selectOne(1);
        return new LinkedHashMap<>();
    }

    /* fixme 二级缓存 */
    @GetMapping("/second")
    public Map<String, Object> second() {
        userMapper.selectOne(1);
        /* 引入Ehcache后CacheManager为EhcacheCacheManager */
        Cache cache = cacheManager.getCache("user");
        userMapper.selectOne(1);
        return new LinkedHashMap<>();
    }

    @GetMapping("/ehcache")
    public Map<String, Object> ehcache() {
        Cache cache = cacheManager.getCache("user");
        cache.put("key", "value");
        System.out.println(cache.get("key", String.class));
        return new LinkedHashMap<>();
    }

}
