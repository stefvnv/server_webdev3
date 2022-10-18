package com.example.lab5_example;

public class User {

    //private fields/attributes
    private String name;
    private String address;


    //public constructor from fields
    public User (String name, String address) {
        super();
        this.name = name;
        this.address = address;
    }

    //public setters and getters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
