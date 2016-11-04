package com.fqc.springboot.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fqc on 11/4/16.
 */

@RestController
@RequestMapping("/index")
@EnableAutoConfiguration//该注解在本类单独启动时需要配置，否则将会出错
public class IndexController {

    @RequestMapping
    public String index() {
        return "hello world test";
    }

    //@EnableAutoConfiguration 该注解在本类单独启动时需要配置，否则将会出错
    public static void main(String[] args) {
        SpringApplication.run(IndexController.class, args);
    }
}

