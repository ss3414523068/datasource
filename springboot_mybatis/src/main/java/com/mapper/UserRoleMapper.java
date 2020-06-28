package com.mapper;

import com.model.UserRole;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleMapper {

    @Select("SELECT `user_role_id`, `user_id`, `role_id` FROM `user_role` " +
            "WHERE `user_id` = #{userId}")
    @Results(id = "BaseResultMap", value = {
            @Result(column = "user_role_id", property = "userRoleId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
            @Result(column = "role_id", property = "roleId", jdbcType = JdbcType.INTEGER),
            /* 根据roleId查询Role */
            @Result(column = "role_id", property = "role", one = @One(select = "com.mapper.RoleMapper.selectOne")),
    })
    List<UserRole> selectListByUserId(Integer userId);

}
