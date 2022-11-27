package com.example.lab5;

public class User {

    //private fields/attributes
    private int id;
    private String name;
    private String address;


    //public constructor from fields
    public User(String name, String address) {
        super();
        this.name = name;
        this.address = address;
    }

    //public setters and getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
