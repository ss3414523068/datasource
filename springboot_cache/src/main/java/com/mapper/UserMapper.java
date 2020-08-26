package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.model.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "user") /* 此处使用了类代理，所以可以在接口上使用@Cache注解 */
public interface UserMapper extends BaseMapper<User> {

    @Cacheable
    @Select("SELECT id, name, password FROM user " +
            "WHERE id = #{id}")
    @Results(id = "BaseResultMap", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
    })
    User selectOne(Integer id);

}
