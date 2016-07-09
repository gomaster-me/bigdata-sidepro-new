package com.fqc.springboot.controller;

import com.fqc.springboot.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public List<Customer> list() {
        return customerList;
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerController.class, args);
    }
}
