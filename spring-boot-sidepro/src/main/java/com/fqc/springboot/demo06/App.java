package com.fqc.springboot.demo06;

import com.fqc.springboot.demo05.BeanConfigController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by fqc on 11/13/16.
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        //SpringApplication.run(Demo.class, args);
        SpringApplication.run(new Object[]{BeanConfigController.class,
                DemoContorller.class, DemoService.class, DemoRepository.class}, args);

    }
}
