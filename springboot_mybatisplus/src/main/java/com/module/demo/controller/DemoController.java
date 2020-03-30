package com.module.demo.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class DemoController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService userService;

    @GetMapping("/user")
    public ModelAndView user() {
        ModelAndView view = new ModelAndView();
        User user = userMapper.selectById(1);
        user = user.selectById(1); /* ActiveRecord */
        view.addObject("user", user);
        view.setViewName("/user");
        return view;
    }

    /* 多数据源 */
    @DS("servlant")
    @GetMapping("/dynamic")
    public ModelAndView dynamic() {
        ModelAndView view = new ModelAndView();
        User user = new User();
        user = userMapper.selectById(1);
        view.addObject("user", user);
        view.setViewName("/user");
        return view;
    }

    @GetMapping("/userPage")
    public Map<String, Object> userPage(@RequestParam(defaultValue = "1") Integer currentPage) {
        Page<User> userPage = new Page<User>();
        userPage.setCurrent(currentPage);
        userPage.setSize(1);
        IPage<User> userList = userMapper.selectPage(userPage, new QueryWrapper<User>().lambda().eq(User::getName, "name123"));
//        IPage<User> userList = userMapper.selectPage(
//                userPage, new QueryWrapper<User>().in("", Arrays.asList(""))
//                        .eq("name", "name123"));

        User user = new User();
        user.setName("name123");
        List<User> userList2 = userService.selectPageByUser(userPage, user); /* 自定义分页 */

//        userList2.forEach(e -> e.setId(null));
//        userService.saveBatch(userList2); /* 批量插入 */

        /* 查询集合（in） */
        List<String> nameList = new ArrayList<>();
        nameList.add("name123");
        nameList.add("name456");
        List<User> userList3 = userMapper.selectList(new QueryWrapper<User>().lambda().in(User::getName, nameList));

        Map<String, Object> map = new HashMap<>();
        map.put("result", userList.getSize());
        return map;
    }

}
