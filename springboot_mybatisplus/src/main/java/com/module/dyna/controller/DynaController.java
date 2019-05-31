package com.module.dyna.controller;

import com.module.dyna.mapper.DynaRoleMapper;
import com.module.dyna.mapper.DynaUserMapper;
import com.module.dyna.model.DynaRole;
import com.module.dyna.model.DynaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/dyna")
public class DynaController {

    @Autowired
    private DynaUserMapper dynaUserMapper;

    @Autowired
    private DynaRoleMapper dynaRoleMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("/insert")
    public String insert() {
        DynaUser dynaUser = new DynaUser();
        dynaUser.setUserName("name1");
        dynaUser.setUserPassword("pwd1");
        String[] roleId = {"1", "2"};
        dynaUser.setRoleId(Arrays.toString(roleId));
        int flag = dynaUserMapper.insert(dynaUser);
        return String.valueOf(flag);
    }

    /* 双表关联 */
    @ResponseBody
    @RequestMapping("/selectOne")
    public String selectOne() {
        DynaUser dynaUser = dynaUserMapper.selectById(1);
        dynaUser.setRoleIdList(dynaUser.getRoleId()); /* 字符串格式数组转换为List */
        List<DynaRole> dynaRoleList = dynaRoleMapper.selectBatchIds(dynaUser.getRoleIdList());
        dynaUser.setRoleList(dynaRoleList);
        return String.valueOf(dynaUser);
    }

    /* 三表关联 */
    @ResponseBody
    @RequestMapping("/selectOne2")
    public String selectOne2() {
        return "";
    }

}
