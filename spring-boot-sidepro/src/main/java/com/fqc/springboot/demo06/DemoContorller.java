package com.fqc.springboot.demo06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fqc on 11/13/16.
 */
@RestController
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
