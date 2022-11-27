package com.example.lab8;

public class User {

    //private fields/attributes
    private int id;
    private String name;
    private String password;
    private String address;


    //public constructor from fields
    public User(String name, String password, String address) {
        super();
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
