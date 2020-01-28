package com.mapper;

import com.model.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "user") /* 此处使用了类代理，所以可以在接口上使用@Cache注解 */
public interface UserMapper {

    int insert(User record);

    int updateByPrimaryKey(User record);

    int deleteByPrimaryKey(Integer id);

    @Cacheable
    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

}
