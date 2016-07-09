package com.fqc.springboot.controller;

import com.fqc.springboot.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fqc on 2016/7/9.
 */
@RestController
@RequestMapping("/customer")
@EnableAutoConfiguration
public class CustomerController {
    public static final ArrayList<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1L, "kobe kobe"));
        customerList.add(new Customer(2L, "james james"));
        customerList.add(new Customer(3L, "jordan jordan"));
    }

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
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
        if (customer == null) {
            //以后可以对象统一消息，封装信息
            //return "not found"; 或者 throw new Exception
            return null;//暂时处理
        }

        return customer;
    }

    @RequestMapping(value = "/add/{name}/{id}", method = RequestMethod.GET) //为了模拟，id这里手动传一下
    public String add(@PathVariable String name, @PathVariable Integer id) {
        Customer customer = null;
        String message = "";

        //customerList.contains() ,可以重写id compareto方法，认为是对象相等，这里就先不做了。
         /*for (Customer c : customerList) {
             if (c.getId().equals(Long.parseLong(id.toString()))) {
                 //v1注意使用equals比较对象，否则即使相等也会判断不等走到下一步修改对象了..很严重的问题
                 //但是id传进来是固定的，遍历的对象的id是不固定的.逻辑有问题
                 message = "已经存在";
             } else {
                 customer = new Customer();
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


    //客户端直接执行delete方法
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
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
