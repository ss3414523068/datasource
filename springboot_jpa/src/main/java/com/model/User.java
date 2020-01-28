package com.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {

    /*
     * ①主键必须为Long？
     * ②MySQL主键自增
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    /* 不在表中的属性 */
    @Transient
    private List<String> nameList;

}
