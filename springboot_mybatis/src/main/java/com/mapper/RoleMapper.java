package com.mapper;

import com.model.Role;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {

    @Select("SELECT `role_id`, `role_name` FROM `role` " +
            "WHERE `role_id` = #{roleId}")
    @Results(id = "BaseResultMap", value = {
            @Result(column = "role_id", property = "roleId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "role_name", property = "roleName", jdbcType = JdbcType.VARCHAR),
    })
    Role selectOne(Integer roleId);

}
