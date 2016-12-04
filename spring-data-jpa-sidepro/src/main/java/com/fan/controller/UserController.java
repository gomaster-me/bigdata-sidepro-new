package com.fan.controller;

import com.fan.model.User;
import com.fan.repository.DataInitialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fqc on 11/20/16.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    DataInitialization dataInitialization;

    @RequestMapping({"helloworld"})
    //@RequestMapping({"","helloworld"})
    public List<User> helloworld() {
        return dataInitialization.helloWorld();
    }

//    @RequestMapping("findByName/{name}")
//    public List<User> findByName(@PathVariable String name) {
//        return dataInitialization.findByName(name);
//    }
}
