package com.fqc.springboot.demo04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Value("${app.name}")
    String appName;
    @Value("${app.code}")
    String appCode;

    @RequestMapping("/appInfo")
    public String info() {
        logger.info("request for /appInfo...{}{}",appName,appCode);
        return "name:" + appName + ",code:" + appCode;
    }
}