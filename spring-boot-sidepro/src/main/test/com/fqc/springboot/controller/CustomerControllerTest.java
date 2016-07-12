package com.fqc.springboot.controller;

import com.fqc.springboot.model.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by fqc on 2016/7/12.
 */
public class CustomerControllerTest extends Assert{
    public static final RestTemplate rt = new RestTemplate();
    private static final String BaseUrl ="http://localhost:8080/customers";

    @Test
    public void list() throws Exception {
        //返回结果封装
        List list = rt.getForObject(BaseUrl, List.class);
        //Assert.assertNotEquals(null,list);
        assertNotNull(list);

        //Response对象封装
        ResponseEntity<List> responseEntity = rt.getForEntity(BaseUrl, List.class);
        assertEquals(responseEntity.getStatusCode().value(),200);

    }

    @Test
    public void getCustomerById() throws Exception {
        ResponseEntity<Customer> response = rt.getForEntity(BaseUrl+"/2", Customer.class);
        assertEquals(response.getStatusCode().value(),200);
        System.out.println(response.getBody().toString());
    }


}