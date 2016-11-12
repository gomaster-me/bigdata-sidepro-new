package com.fqc.springboot.demo02;

import com.fqc.springboot.demo02.controller.IndexController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by fqc on 11/12/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ApplicationTest {
    public MockMvc mockMvc;


    @Before
    public void before() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();//new IndexController().getClass()...
    }

    @Test
    public void contextLoads() throws Exception {
        RequestBuilder req = get("/index/demo02/test/");
        mockMvc.perform(req).andExpect(status().isOk()).andExpect(content().string("hello spring boot"));
    }
}