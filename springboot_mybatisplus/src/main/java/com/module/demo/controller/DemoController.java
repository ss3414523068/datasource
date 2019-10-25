package com.module.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.module.demo.mapper.UserMapper;
import com.module.demo.model.User;
import com.module.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("")
public class DemoController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService userService;

    @GetMapping("/user")
    public ModelAndView user() {
        ModelAndView view = new ModelAndView("/user");

        User user = new User();
        user = userMapper.selectById(1);
        user = user.selectById(1);

        view.addObject("user", user);
        return view;
    }

    @GetMapping("/userPage")
    public String userPage(@RequestParam(defaultValue = "1") Integer currentPage) {
        User user = new User();
        user.setName("name1");
        Page<User> userPage = new Page<User>();
        userPage.setCurrent(currentPage);
        userPage.setSize(1);

        IPage<User> userList = userMapper.selectPage(userPage, new QueryWrapper<User>().lambda().eq(User::getName, "name1"));
        /* 自定义分页 */
        List<User> userList2 = userService.selectPageByUser(userPage, user);
        return String.valueOf(userList.getSize());
    }

}
