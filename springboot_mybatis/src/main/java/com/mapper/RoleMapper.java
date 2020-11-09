package com.mapper;

import com.model.Role;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    @Select("SELECT role_id, role_name FROM role " +
            "WHERE role_id = #{roleId}")
    @Results(id = "BaseResultMap", value = {
            @Result(column = "role_id", property = "roleId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "role_name", property = "roleName", jdbcType = JdbcType.VARCHAR),
    })
    Role selectOne(Integer roleId);

    @Select("SELECT role.* FROM role,user_role " +
            "WHERE role.role_id=user_role.role_id " +
            "AND user_role.user_id = #{userId}")
    @ResultMap(value = "BaseResultMap")
    List<Role> selectListByUserId(Integer userId);

    List<Role> selectListByUserId2(Integer userId);

}
