package com.fqc.springboot.demo05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
