package com.mapper;

import com.model.User;
import org.springframework.stereotype.Repository;

/* 不加@Repository Idea会提示错误（但不影响正常使用） */
@Repository
public interface UserMapper extends MyMapper<User> {
}