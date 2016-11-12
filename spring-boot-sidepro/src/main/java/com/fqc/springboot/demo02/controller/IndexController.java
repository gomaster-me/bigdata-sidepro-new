package com.fqc.springboot.demo02.controller;

import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fqc on 11/12/16.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/index/demo02")
public class IndexController {

    @RequestMapping
    public String index() {
        return "hello spring boot";
    }
}
