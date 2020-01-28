package com.mapper;

import com.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @CacheEvict(value = "user", key = "0", beforeInvocation = true) /* 执行insert方法后清除user缓存 */
    int insert(User record);

    int insertSelective(User record);

    int updateByPrimaryKey(User record);

    int updateByPrimaryKeySelective(User record);

    @CacheEvict(value = "user", allEntries = true) /* 清除所有缓存 */
    int deleteByPrimaryKey(Integer id);

    User selectByPrimaryKey(Integer id);

    @Cacheable(value = "user", key = "0")
    List<User> selectAll();

}
