package com.module.dyna.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("dynamic_user")
public class DynaUser extends Model<DynaUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    private String userName;

    private String userPassword;

    private String roleId;

    @TableField(exist = false)
    private List<String> roleIdList;

    @TableField(exist = false)
    private List<DynaRole> roleList;

    public void setRoleIdList(List<String> roleIdList) {
        this.roleIdList = roleIdList;
    }

    /* 将[1, 2]转换为List */
    public void setRoleIdList(String roleId) {
        roleId = roleId.substring(1, roleId.length() - 1).replaceAll("\\s", "");
        this.roleIdList = Arrays.asList(roleId.split(","));
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
