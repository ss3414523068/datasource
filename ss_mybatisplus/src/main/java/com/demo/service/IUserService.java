package com.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.model.User;

import java.util.List;

public interface IUserService extends IService<User> {

    List<User> selectPageByUser(Page page, User user);

}
