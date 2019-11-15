package com.demo.controller;

import com.demo.dao.UserDao;
import com.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("")
public class DemoController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/create")
    public Map create() {
        User user = new User();
        user.setName("name1");
        user.setPassword("pwd1");
        Map map = new HashMap();
        map.put("result", userDao.save(user));
        return map;
    }

    @GetMapping("/update")
    public Map update() {
        User user = new User();
        user.setId(1L);
        user.setName("name2");
        user.setPassword("pwd2");
        Map map = new HashMap();
        map.put("result", userDao.save(user));
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

}
