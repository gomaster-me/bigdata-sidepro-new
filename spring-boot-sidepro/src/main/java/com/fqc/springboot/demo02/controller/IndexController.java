package com.fqc.springboot.demo02.controller;

import com.fqc.springboot.demo02.domain.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fqc on 11/12/16.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/index/demo02")
public class IndexController {

    @RequestMapping("test")
    public String index() {
        return "hello spring boot";
    }

    @RequestMapping("get")
    public Map<String,String> get(@RequestParam String name) {
        Map map = new HashMap<String,String>();
        map.put("key", name);
        map.put("value", "hello world");
        return map;
        //http://localhost:8080/index/demo02/get?name=科比
        /*{
            value: "hello world",
                    key: "科比" //utf-8编码
        }*/
    }


    @RequestMapping("find/{id}/{name}")//{name} 要与@PathVariable 修饰的变量名称对应
    public User find(@PathVariable Integer id, @PathVariable String name) {
        User user = new User(id,name);
        user.setDate(new Date());
        return user;
    }
}
