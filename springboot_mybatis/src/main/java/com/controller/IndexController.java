package com.controller;

import com.github.pagehelper.PageHelper;
import com.mapper.UserMapper;
import com.mapper.UserRoleMapper;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    /* 注解CURD */
    @GetMapping("/curd")
    public Map<String, Object> curd() {
        userMapper.insert(User.builder().name("name1").build());
        userMapper.update(User.builder().id(1).name("name2").build());
        userMapper.delete(1);
        return new LinkedHashMap<>();
    }

    @GetMapping("/userPage")
    public Map<String, Object> userPage(@RequestParam(defaultValue = "1") Integer currentPage) {
        /* PageHelper分页插件 */
        PageHelper.startPage(currentPage, 2);
        List<User> userList = userMapper.selectList();

        Map<String, Object> map = new HashMap<>();
        map.put("result", userList.size());
        return map;
    }

    @Autowired
    private UserRoleMapper userRoleMapper;

    /* 关联 */
    @GetMapping("/related")
    public Map<String, Object> related() {
//        List<UserRole> userRoleList = userRoleMapper.selectListByUserId(1);

        /*
         * 与JPA相比
         * ①优点：更灵活
         * ②缺点：需要手写SQL
         * */
        User user = userMapper.selectRelatedOne(1);

        return new LinkedHashMap<>();
    }

}
