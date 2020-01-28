package com;

import com.dao.UserDao;
import com.model.User;
import com.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTest {

    @Autowired
    private UserDao userDao;

//    @Test
    public void test() {
        /* 因为name22超过长度，所以name22/name3将不被插入 */
        userDao.save(new User("name1", "pwd1"));
        userDao.save(new User("name22", "pwd2"));
        userDao.save(new User("name3", "pwd3"));
    }

    /* fixme 无论spring/javax的事务都没有回滚 */
    @Test
    @Transactional
    public void test2() {
        userDao.save(new User("name1", "pwd1"));
        userDao.save(new User("name22", "pwd2"));
        userDao.save(new User("name3", "pwd3"));
    }

    /************************************************************分割线************************************************************/

    /*
     * ①@Autowired属于Spring，默认按类型装配
     * ②@Resource属于Java，默认按名称装配
     * */
    @Resource
    private UserService userService;

    /* fixme UserServiceImpl加上@Transactional注解，注入的是UserServiceImpl代理对象 */
//    @Test
    public void test3() {
        System.out.println(userService.getClass().getName()); /* UserServiceImpl */
    }

}
