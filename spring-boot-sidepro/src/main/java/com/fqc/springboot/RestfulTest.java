package com.fqc.springboot;

import com.fqc.springboot.controller.CustomerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest-api")
@EnableAutoConfiguration
public class RestfulTest {

    @RequestMapping(value = {"/index", ""})
    public String home() {
        return "hello spring boot";
    }

    //region 参数提交测试--------------------------------------------------------------------
    @RequestMapping(value = "", method = RequestMethod.GET)
    //http://localhost:8080/rest-api?name=kobe
    public String greetings_get(String name) {
        return "hello," + name;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    //postman中直接提交文本 需要@RequestBody接收。
    //当然form data 直接传name value 都可以传递参数，且不需要@RequestBody
    public String greetings_post(@RequestBody String name) {
        return String.format("hello,%s", name);
    }

    @RequestMapping(value = "/v2", method = RequestMethod.POST)
    //通过该实验，form-data的形式提交 参数类型对应上即可。不用postman中那纯文本提交参数。
    public String greetings_post_v2(String name,Integer id) {
        return String.format("hello,%s,%d", name,id);
    }

    @RequestMapping(value = "/{name}/{id}", method = RequestMethod.POST)
    //http://localhost:8080/rest-api/kobe/1 ,通过uri方式映射
    public String greetings_post_v3(@PathVariable String name, @PathVariable String id) {
        return String.format("hello,%s, %s", name, id);
    }

    //endregion 参数提交测试结束--------------------------------------------------------------------

    public static void main(String[] args) {
        SpringApplication.run(new Object[]{RestfulTest.class, CustomerController.class}, args);
    }
}