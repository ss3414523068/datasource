package com.controller;

import com.mapper.UserMapper;
import com.model.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/user")
    public ModelAndView user() {
        ModelAndView view = new ModelAndView();
        User user = userMapper.selectByPrimaryKey(1);
        user = userRepository.findOne(1);
        view.addObject("user", user);
        view.setViewName("/user");
        return view;
    }

}
