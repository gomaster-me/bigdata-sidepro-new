package com.fqc.springboot.demo02;

import com.fqc.springboot.demo02.controller.IndexController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by fqc on 11/12/16.
 */
@SpringBootApplication

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(IndexController.class,args);
    }
}
