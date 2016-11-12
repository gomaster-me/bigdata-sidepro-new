package com.fqc.springboot.demo02.domain;

import java.util.Date;

/**
 * Created by fqc on 11/12/16.
 */
public class User {
    private Integer id;
    private String name;
    private Date date;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
