package com.fqc.springboot.demo03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by fqc on 11/12/16.
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(PropertyController.class,args);
    }
}
