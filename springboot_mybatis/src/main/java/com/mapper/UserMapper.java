package com.mapper;

import com.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    /* 注意换行前的空格 */
    @Insert("INSERT INTO `user` (`name`, `password`) " +
            "VALUES (#{name}, #{password})")
    int insert(User record);

    @Update("UPDATE `user`" +
            "SET `name` = #{name}, `password` = #{password} " +
            "WHERE `id` = #{id}")
    int update(User record);

    @Delete("DELETE FROM `user` " +
            "WHERE `id` = #{id}")
    int delete(Integer id);

    @Select("SELECT `id`, `name`, `password` FROM `user` " +
            "WHERE `id` = #{id}")
    @Results(id = "BaseResultMap", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
    })
    User selectOne(Integer id);

    /* @ResultMap复用@Results */
    @Select("SELECT `id`, `name`, `password` FROM `user`")
    @ResultMap(value = "BaseResultMap")
    List<User> selectList();

    @Select("SELECT `id`, `name`, `password` FROM `user` " +
            "WHERE `id` = #{id}")
    @Results(id = "RelatedResultMap", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
            /* 根据userId查询UserRole */
            @Result(column = "id", property = "userRoleList", javaType = List.class, many = @Many(select = "com.mapper.UserRoleMapper.selectListByUserId")),
    })
    User selectRelatedOne(Integer id);

}
