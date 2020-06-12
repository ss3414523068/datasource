package com.controller;

import com.dao.UserDao;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

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
        user.setId(null);
        user.setName("name2");
        Map map = new HashMap();
        map.put("result", userDao.saveAndFlush(user)); /* 搭配hutool copyProperties只更新非null */
        return map;
    }

    @GetMapping("/delete")
    public Map delete() {
        userDao.deleteById(1);
        Map map = new HashMap();
        map.put("result", "delete");
        return map;
    }

    @GetMapping("/selectOne")
    public ModelAndView selectOne() {
        ModelAndView view = new ModelAndView();
        Optional<User> result = userDao.findById(1);
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
        Sort sort = new Sort(Sort.Direction.DESC, "id"); /* 排序 */
        List<User> userList = userDao.findAll(userExample, sort);
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
//        System.out.println(userDao.customInsert("name123", "pwd1"));
//        System.out.println(userDao.customUpdate(1, "name456", "pwd2"));
//        System.out.println(userDao.customDelete(1));
        Pageable pageable = PageRequest.of(0, 1);
        List<LinkedHashMap<String, Object>> userList = userDao.customList("name1", pageable);

//        List<User> userList = userDao.findAll(); /* 关联查询 */

        /* 关联插入（同时插入user/user_role） */
//        Set<Role> roleList = new LinkedHashSet<>(Arrays.asList(
//                Role.builder().roleId("4d201114-7f13-40b9-abea-e7d7b00b183b").roleName("role1").build(),
//                Role.builder().roleId("c83b950a-9ff5-11ea-bf9d-94c6910c8b5c").roleName("role2").build()));
//        User user = User.builder()
//                .name("name1")
//                .roleList(roleList)
//                .build();
//        userDao.save(user);

//        /* 关联更新 */
//        Set<Role> roleList = new LinkedHashSet<>(Arrays.asList(Role.builder().roleId("4d201114-7f13-40b9-abea-e7d7b00b183b").roleName("role1").build()));
//        User user = User.builder()
//                .id("877dd8c2-e7c3-4690-8778-f882a22d8093")
//                .name("name1")
////                .roleList(roleList)
//                .build();
//        userDao.saveAndFlush(user);
        return new LinkedHashMap();
    }

}
