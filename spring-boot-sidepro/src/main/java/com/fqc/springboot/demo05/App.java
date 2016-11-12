package com.fqc.springboot.demo05;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

/**
 * Created by fqc on 11/13/16.
 */
@SpringBootApplication
public class App {

//    @Value("${app.name}")
//    private  static String name ;



    public static void main(String[] args) {
        //SpringApplication.run(BeanConfigController.class,args);
        SpringApplication app = new SpringApplication(BeanConfigController.class);
        /*app.setBanner(new Banner() {
            @Override
            public void printBanner(Environment environment, Class<?> aClass, PrintStream printStream) {
                System.out.println("fengqc");
            }
        });*/
        //app.setBannerMode(Banner.Mode.OFF);//setShowBanner(false)
        //app.setBannerMode(mode);
        app.run(args);
    }
}
