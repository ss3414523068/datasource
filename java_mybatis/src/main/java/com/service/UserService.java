package com.service;

import com.dao.IUserDao;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private IUserDao userDao;

    /*
     * @Transactional
     * ①不能用于Controller中
     * ②包含Dao操作
     * */
    @Transactional
    public void transaction() {
        userDao.insert(User.builder().build());
        String name = "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        userDao.insert(User.builder().name(name).build());
    }

}
