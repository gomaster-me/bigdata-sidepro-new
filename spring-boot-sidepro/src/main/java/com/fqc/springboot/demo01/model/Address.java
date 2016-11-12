package com.fqc.springboot.demo01.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by fqc on 2016/7/9.
 */
public class Address {
    private String Ststreet = "renhe";
    private String city = "beijing";
    private String state = "haidian";
    private String pin ="1000068";

    public String getStstreet() {
        return Ststreet;
    }

    public void setStstreet(String ststreet) {
        Ststreet = ststreet;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @JsonIgnore
    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "Address{" +
                "Ststreet='" + Ststreet + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }
}
