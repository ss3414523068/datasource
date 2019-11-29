package com.controller;

import com.dao.UserDao;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("")
public class IndexController {

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    /************************************************************分割线************************************************************/

    @Autowired
    private UserDao userDao;

    @GetMapping("/create")
    public Map create() {
        User user = new User();
        user.setName("姓名1");
        user.setPassword("密码1");
        Map map = new HashMap();
        map.put("result", userDao.save(user));
        return map;
    }

    @GetMapping("/update")
    public Map update() {
        User user = new User();
        user.setId(7L);
        user.setName("name2");
        Map map = new HashMap();
        map.put("result", userDao.saveAndFlush(user)); /* fixme 只更新非Null属性 */
        return map;
    }

    @GetMapping("/delete")
    public Map delete() {
        userDao.deleteById(1L);
        Map map = new HashMap();
        map.put("result", "delete");
        return map;
    }

    @GetMapping("/selectOne")
    public ModelAndView selectOne() {
        ModelAndView view = new ModelAndView();
        Optional<User> result = userDao.findById(1L);
        User user = new User();
        if (result.isPresent()) {
            user = result.get();
        }
        view.addObject("user", user);
        view.setViewName("/user");
        return view;
    }

    @GetMapping("/selectList")
    public Map selectList() {
        Map map = new HashMap();
        map.put("result", userDao.findAll());
        return map;
    }

    /* JPA Example查询 */
    @GetMapping("/selectExample")
    public Map selectExample() {
        User user = new User();
        user.setName("name123");
        Example<User> userExample = Example.of(user);
        List<User> userList = userDao.findAll(userExample);
        System.out.println(userList);

        User user2 = new User();
        user2.setName("123");
        user2.setPassword("pwd");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("password", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<User> userExample2 = Example.of(user2, matcher);
        List<User> userList2 = userDao.findAll(userExample2); /* 查询name包含123，pwd包含pwd的记录 */
        System.out.println(userList2);
        Map map = new HashMap();
        return map;
    }

    /* 自定义CURD */
    @GetMapping("/custom")
    public Map custom() {
        User user = new User();
        user.setName("name123");
        user.setPassword("pwd1");
        System.out.println(userDao.customInsert("name123", "pwd1"));
        System.out.println(userDao.customUpdate(1L, "name456", "pwd2"));
        System.out.println(userDao.customDelete(1L));
        System.out.println(userDao.customList("name123", "pwd1"));
        Map map = new HashMap();
        return map;
    }

}
