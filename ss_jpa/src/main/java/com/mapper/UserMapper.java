package com.mapper;

import com.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    int insert(User record);

    int insertSelective(User record);

    int updateByPrimaryKey(User record);

    int updateByPrimaryKeySelective(User record);

    int deleteByPrimaryKey(Integer id);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

}
