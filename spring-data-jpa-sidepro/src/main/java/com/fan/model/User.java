package com.fan.model;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    private String address;
    private String phone;
//    private VehicleIdentificationNumber vin;

//    public VehicleIdentificationNumber getVin() {
//        return vin;
//    }

//    public void setVin(VehicleIdentificationNumber vin) {
//        this.vin = vin;
//    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String email;


    protected User() {
    }

//    public User(String name, VehicleIdentificationNumber vin) {
//        this.name = name;
//        this.vin = vin;
//    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, name='%s', email='%s',address='%s',phone='phone']",
                id, name, email,address,phone);
    }

    public static void main(String[] args) {
        User kobe = new User("kobe", "eee.com");
        System.out.println(kobe);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}