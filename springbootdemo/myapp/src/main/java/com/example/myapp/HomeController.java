package com.example.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @RequestMapping("/")
    public String greetings() {
        logger.info("/ 根路径访问");
        return "hello SpringBootApplication";
    }

    @RequestMapping(value = "/test")
    public String testLogLevel() {
        logger.debug("Logger Level ：DEBUG");
        logger.info("Logger Level ：INFO");
        logger.error("Logger Level ：ERROR");
        return "";
    }

    public static void main(String[] args) {
        SpringApplication.run(HomeController.class, args);
    }
}