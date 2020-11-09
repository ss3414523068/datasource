package com.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.mapper.UserMapper;
import com.demo.model.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class DemoController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public ModelAndView user() {
        ModelAndView view = new ModelAndView();

        User user = new User();
        user = userMapper.selectById(1);
        user = userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getId, 1));

        view.addObject("user", user);
        view.setViewName("/user");
        return view;
    }

}
