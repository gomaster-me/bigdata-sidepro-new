package com.fqc.springboot.demo01;

import com.fqc.springboot.demo01.controller.CustomerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fqc on 8/6/16.
 * 启动类
 */
@SpringBootApplication
public class AppDriver {

    public static void main(String[] args) {
        SpringApplication.run(new Object[]{
                //IndexController.class,
                CustomerController.class, RestfulTest.class
        }, args);
    }
}