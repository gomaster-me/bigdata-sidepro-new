package com.fqc.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest-api")
@EnableAutoConfiguration
public class RestFulTest {

    @RequestMapping(value={"/index",""})
    public String home() {
        return "hello spring boot";
    }

    public static void main(String[] args) {
        SpringApplication.run(RestFulTest.class, args);
    }
}