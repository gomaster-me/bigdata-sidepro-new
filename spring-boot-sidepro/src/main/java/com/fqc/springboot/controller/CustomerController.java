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

    @RequestMapping(value = {"/list",""}, method = RequestMethod.GET)
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

    public static void main(String[] args) {
        SpringApplication.run(CustomerController.class, args);
    }
}
