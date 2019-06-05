package com.demo.controller;

import com.demo.model.User;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    UserRepository userRepository;

    @ResponseBody
    @RequestMapping("/save")
    public String save() {
        User user = new User();
        user.setName("name1");
        user.setPassword("pwd1");
        User result = userRepository.save(user);
        return result.toString();
    }

    @ResponseBody
    @RequestMapping("/update")
    public String update() {
        User user = new User();
        user.setId(1L);
        user.setName("name2");
        user.setPassword("pwd2");
        User result = userRepository.save(user);
        return result.toString();
    }

    @ResponseBody
    @RequestMapping("/delete")
    public String delete() {
        userRepository.deleteById(1L);
        return "delete";
    }

    @RequestMapping("/selectOne")
    public ModelAndView selectOne() {
        ModelAndView view = new ModelAndView("/user");
        Optional<User> result = userRepository.findById(1L);
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
        List<User> resultList = userRepository.findAll();
        return resultList.toString();
    }

}
