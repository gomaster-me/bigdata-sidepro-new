package com.fqc.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest-api")
@EnableAutoConfiguration
public class RestFulTest {

    @RequestMapping(value = {"/index", ""})
    public String home() {
        return "hello spring boot";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    //http://localhost:8080/rest-api?name=kobe
    public String greetings_get(String name) {
        return "hello," + name;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    //postman中直接传递文本 需要@RequestBody接收。
    //当然form data 直接传name value 都可以传递参数，且不需要@RequestBody
    public String greetings_post(@RequestBody String name) {
        return String.format("hello,%s", name);
    }

    public static void main(String[] args) {
        SpringApplication.run(RestFulTest.class, args);
    }
}