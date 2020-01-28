package com.module.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@TableName("user")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String password;

    /*
     * 问题
     * ①表中不存在字段
     * ②Lambda自动驼峰问题
     * */
    @TableField(exist = false)
    private List nameList;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
