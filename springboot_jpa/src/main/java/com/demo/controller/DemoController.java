package com.demo.controller;

import com.demo.model.User;
import com.demo.repository.UserRepository;
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
        user.setId(7L);
        user.setName("name2");
        User result = userRepository.saveAndFlush(user); /* fixme 只更新非Null属性 */
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

    /* JPA Example查询 */
    @ResponseBody
    @RequestMapping("/selectExample")
    public String selectExample() {
        User user = new User();
        user.setName("name123");
        Example<User> userExample = Example.of(user);
        List<User> userList = userRepository.findAll(userExample);
        System.out.println(userList);

        User user2 = new User();
        user2.setName("123");
        user2.setPassword("pwd");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("password", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<User> userExample2 = Example.of(user2, matcher);
        List<User> userList2 = userRepository.findAll(userExample2); /* 查询name包含123，pwd包含pwd的记录 */
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
        System.out.println(userRepository.customInsert("name123", "pwd1"));
        System.out.println(userRepository.customUpdate(1L, "name456", "pwd2"));
        System.out.println(userRepository.customDelete(1L));
        System.out.println(userRepository.customList("name123", "pwd1"));
        return "";
    }

}
