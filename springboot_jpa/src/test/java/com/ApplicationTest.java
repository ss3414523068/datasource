package com;

import com.dao.UserDao;
import com.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ApplicationTest {

    @Autowired
    private UserDao userDao;

    @Test
    @Transactional
    public void test() {
        /*
         * ①因为name22超过长度，name3为null，三条记录将均不插入
         * ②回滚后查看自增Id
         * */
        userDao.save(User.builder().name("name1").password("pwd1").build());
        userDao.save(User.builder().name("name22").password("pwd2").build());
        userDao.save(User.builder().password("pwd3").build());
    }

}
