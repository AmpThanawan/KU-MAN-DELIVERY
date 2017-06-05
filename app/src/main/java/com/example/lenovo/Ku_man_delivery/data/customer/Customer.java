package com.example.lenovo.Ku_man_delivery.data.customer;

/**
 * Created by thanawan on 6/5/2017 AD.
 */

public class Customer {

    private String name;
    private String lastname;
    private String location ;

    public Customer(String name, String lastname , String location) {

        this.name = name;
        this.lastname = lastname ;
        this.location =location ;




    }

    public String toString() {
        return  name ;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLocation() {
        return location;
    }


}
