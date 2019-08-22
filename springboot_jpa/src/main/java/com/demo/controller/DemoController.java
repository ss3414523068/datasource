package com.demo.controller;

import com.demo.dao.UserDao;
import com.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class DemoController {

    @Autowired
    UserDao userDao;

    @ResponseBody
    @RequestMapping("/save")
    public String save() {
        User user = new User();
        user.setName("name1");
        user.setPassword("pwd1");
        User result = userDao.save(user);
        return result.toString();
    }

    @ResponseBody
    @RequestMapping("/update")
    public String update() {
        User user = new User();
        user.setId(7L);
        user.setName("name2");
        User result = userDao.saveAndFlush(user); /* fixme 只更新非Null属性 */
        return result.toString();
    }

    @ResponseBody
    @RequestMapping("/delete")
    public String delete() {
        userDao.deleteById(1L);
        return "delete";
    }

    @RequestMapping("/selectOne")
    public ModelAndView selectOne() {
        ModelAndView view = new ModelAndView("/user");
        Optional<User> result = userDao.findById(1L);
        User user = new User();
        if (result.isPresent()) {
            user = result.get();
        }
        view.addObject("user", user);
        return view;
    }

    @ResponseBody
    @RequestMapping("/selectList")
    public String selectList() {
        List<User> resultList = userDao.findAll();
        return resultList.toString();
    }

    /* JPA Example查询 */
    @ResponseBody
    @RequestMapping("/selectExample")
    public String selectExample() {
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
        return "";
    }

    /* 自定义CURD */
    @ResponseBody
    @RequestMapping("/custom")
    public String custom() {
        User user = new User();
        user.setName("name123");
        user.setPassword("pwd1");
        System.out.println(userDao.customInsert("name123", "pwd1"));
        System.out.println(userDao.customUpdate(1L, "name456", "pwd2"));
        System.out.println(userDao.customDelete(1L));
        System.out.println(userDao.customList("name123", "pwd1"));
        return "";
    }

}
