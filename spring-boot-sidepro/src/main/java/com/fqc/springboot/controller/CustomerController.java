package com.fqc.springboot.controller;

import com.fqc.springboot.exception.CustomerNotFoundException;
import com.fqc.springboot.model.Customer;
import com.fqc.springboot.model.SimpleCustomer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fqc on 2016/7/9.
 */
@RestController
@RequestMapping("/customers")
@EnableAutoConfiguration
//@SpringBootApplication//内部实现包含了EnableAutoConfiguration
public class CustomerController {
    public static final ArrayList<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1L, "kobe kobe"));
        customerList.add(new Customer(2L, "james james"));
        customerList.add(new Customer(3L, "jordan jordan"));
    }

    @RequestMapping(value ={"","/list"}, method = RequestMethod.GET)
    public List<Customer> list() {
        return customerList;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable Integer id) {
        Customer customer = null;
        for (Customer c : customerList) {
            if (c.getId() == Long.parseLong(id.toString())) {
                customer = c;
            }
        }
        if (customer == null) { //注意在内存中删除后，再执行该方法会奏效~
            //以后可以对象统一消息，封装信息
            //return "not found"; 或者 throw new Exception
            throw new CustomerNotFoundException();
        }

        return customer;
    }

    @RequestMapping(value = "/add/{name}/{id}", method = RequestMethod.GET) //为了模拟，id这里手动传一下。// TODO: 2016/7/10
    public String add(@PathVariable String name, @PathVariable Integer id) {
        Customer customer = null;
        String message = "";

        //customerList.contains() ,可以重写id compareto方法，认为是对象相等，这里就先不做了。
         /*for (Customer.java c : customerList) {
             if (c.getId().equals(Long.parseLong(id.toString()))) {
                 //v1注意使用equals比较对象，否则即使相等也会判断不等走到下一步修改对象了..很严重的问题
                 //但是id传进来是固定的，遍历的对象的id是不固定的.逻辑有问题
                 message = "已经存在";
             } else {
                 customer = new Customer.java();
                 customer.setId(Long.parseLong(id.toString()));
                 customerList.add(customer);
                 message = "增加ok";
                 //return message;; //v0注意这里一定要return或break，绝不允许再继续循环下去。
                 break;
             }
        }*/

        for (Customer c : customerList) {
            if (c.getId().equals(Long.parseLong(id.toString()))) {
                message = "已经存在";
                return message;
            }
        }
        customer = new Customer();
        customer.setId(Long.parseLong(id.toString()));
        customerList.add(customer);
        message = "增加ok";

        return message;

    }

    //@RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    //@ResponseBody
    public void addCustomer(@RequestBody Customer customer) {
        customerList.add(customer);


        // TODO: 2016/7/11  目前是415错误，换一种思路先
        /*{
            "timestamp": 1468244852118,
                "status": 415,
                "error": "Unsupported Media Type",
                "exception": "org.springframework.web.HttpMediaTypeNotSupportedException",
                "message": "Content type 'text/plain;charset=UTF-8' not supported",
                "path": "/customer"
        }*/
    }


    //    region  for 415 error. 最终的解决方案是 使用 Advancated rest client 添加了头部 Content-Type application/json 直接就成功了
    //4xx 客户端问题
    //5xx 服务端问题
    //这里的内容可以参看 https://github.com/spring-projects/spring-boot/issues/3313
    //http://briansjavablog.blogspot.jp/2012/08/rest-services-with-spring.html
    //http://forum.spring.io/forum/spring-projects/web/116053-http-4115-unsupported-media-type-application-json
    //http://www.coderanch.com/t/605202/Spring/Spring-mvc-request-mapping-POST
    //http://stackoverflow.com/questions/14751536/http-status-415-unsupported-media-type
    public static final ArrayList scs = new ArrayList();

    static {
        scs.add(new SimpleCustomer("1", "zhangsan1"));
        scs.add(new SimpleCustomer("2", "zhangsan2"));
        scs.add(new SimpleCustomer("3", "zhangsan3"));
    }


    @RequestMapping(value = "/sc", method = RequestMethod.GET)
    public List<SimpleCustomer> getAll(SimpleCustomer sc) {
        return scs;
    }

    @RequestMapping(value = "/sc", method = RequestMethod.POST)
    public void addSimpleCustomer(@RequestBody SimpleCustomer sc) {
        scs.add(sc);

    }


//    endregion


    @RequestMapping(value = "/{id}/{name}", method = RequestMethod.POST)
    public String update(@PathVariable Integer id, @PathVariable String name) {
        String message = "更新失败";

        for (Customer c : customerList) {
            if (c.getId() == Long.parseLong(id.toString())) {
                c.setName(name);
                message = "修改成功";
                return message;
            } else {
                message = "未找到";
            }
        }

        return message;
    }


    //客户端直接执行delete方法
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        String message = "删除失败";
        for (Customer c : customerList) {
            if (c.getId() == Long.parseLong(id.toString())) {
                customerList.remove(c);

                //break;//还是要break;
                message = "删除成功";
                return message;
            }
            message = "未找到";
        }
        return message;

    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerController.class, args);
    }
}
