package com.controller;

import com.github.pagehelper.PageHelper;
import com.mapper.UserMapper;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/user")
    public ModelAndView user() {
        ModelAndView view = new ModelAndView("/user");

        User user = userMapper.selectByPrimaryKey(1);

        view.addObject("user", user);
        return view;
    }

    @ResponseBody
    @RequestMapping("/userPage")
    public String userPage(@RequestParam(defaultValue = "1") Integer currentPage) {

        /* PageHelper分页插件 */
        PageHelper.startPage(currentPage, 2);
        List<User> userList = userMapper.selectAll();

        return String.valueOf(userList.size());
    }

}
