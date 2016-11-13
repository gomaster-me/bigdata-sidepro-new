package com.fqc.springboot.demo06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fqc on 11/13/16.
 */
@Service
@EnableAutoConfiguration
public class DemoService {
    @Autowired
    private DemoRepository demoRepository;

    public List<Demo> findAll() {
        Iterable<Demo> all = demoRepository.findAll();
        List list = new ArrayList();
        for (Demo demo : all) {
            System.out.println(demo);
            list.add(demo);
        }
        return list;
    }

}
