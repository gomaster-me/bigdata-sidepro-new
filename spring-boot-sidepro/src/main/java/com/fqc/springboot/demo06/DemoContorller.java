package com.fqc.springboot.demo06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fqc on 11/13/16.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/demo")
public class DemoContorller {
    @Autowired
    private DemoService demoService;

//    @Bean
//    public DemoService demoService() {
//        return demoService;
//    }

    @RequestMapping("list")
    public List<Demo> get() {
        return demoService.findAll();
    }
}
