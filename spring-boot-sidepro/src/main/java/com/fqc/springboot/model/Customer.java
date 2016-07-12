package com.fqc.springboot.model;

/**
 * Created by fqc on 2016/7/9.
 */
public class Customer {
    private Long id;
    private String name;

//    private Address address;
    private Address address = new Address(); //默认就初始化地址

    public Customer() {
    }

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
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


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    //region comment region
    /**
     *  /*
     *  only id setter and getter
     *  [
     {
     "id": 1
     },
     {
     "id": 2
     },
     {
     "id": 3
     }
     ]*/

   /* [  id,name getter and setter
    {
        "id": 1,
            "name": "kobe kobe"
    },
    {
        "id": 2,
            "name": "james james"
    },
    {
        "id": 3,
            "name": "jordan jordan"
    }
    ]
     */
//endregion


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
