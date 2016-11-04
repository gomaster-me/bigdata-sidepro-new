package com.fqc.springboot;

import com.fqc.springboot.controller.CustomerController;
import com.fqc.springboot.controller.IndexController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fqc on 8/6/16.
 * 启动类
 */
@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class AppDriver {

    public static void main(String[] args) {
        SpringApplication.run(new Object[]{
                //IndexController.class,
                CustomerController.class, RestfulTest.class
        }, args);
    }
}