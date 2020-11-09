package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.**.mapper")
public class MyBatis extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MyBatis.class, args);
    }

}
