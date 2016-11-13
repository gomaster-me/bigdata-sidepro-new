package com.fqc.springboot.demo03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fqc on 11/12/16.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/property")
//@Profile("test") 只有在配置spring.profiles.active为test生效
public class PropertyController {

    @Value("${app.name}")
    private String appName;
    @Value("${app.code}")
    private String appCode;

    @Value("${app.secret}")
    private String random;

    @Value("${app.number}")
    private String randomInt;
    @Value("${app.desc}")
    private String desc;
    @RequestMapping("find")
    public Map<String, String> find() {
        Map<String, String> map = new HashMap<>();
        map.put("appName", appName);
        map.put("appCode", appCode);
        map.put("secret", random);
        map.put("number", randomInt);
        map.put("app.desc", desc);
        return map;
    }
}
