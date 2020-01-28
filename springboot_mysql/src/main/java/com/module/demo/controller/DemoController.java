package com.module.demo.controller;

import com.module.demo.mapper.UserMapper;
import com.module.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("")
public class DemoController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public ModelAndView user() {
        ModelAndView view = new ModelAndView();
        User user = userMapper.selectById(1);
        view.addObject("user", user);
        view.setViewName("/user");
        return view;
    }

}
