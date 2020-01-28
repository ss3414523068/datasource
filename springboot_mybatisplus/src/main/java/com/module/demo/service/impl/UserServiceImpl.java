package com.module.demo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.module.demo.mapper.UserMapper;
import com.module.demo.model.User;
import com.module.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectPageByUser(Page page, User user) {
        return userMapper.selectPageByUser(page, user);
    }

}
