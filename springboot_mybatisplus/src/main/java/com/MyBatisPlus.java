package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class MyBatisPlus {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisPlus.class, args);
    }

}
