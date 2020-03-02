package com.dao;

import com.model.User;

public interface IUserDao {

    int insert(User user);

    User selectById(User user);

}
