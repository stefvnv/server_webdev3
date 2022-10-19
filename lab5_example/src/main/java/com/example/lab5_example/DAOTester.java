package com.example.lab5_example;

import java.util.ArrayList;
import java.util.List;

public class DAOTester {
    public static void main(String[] args) {

        ArrayList<User> userList = UserDAO.instance.list();

        for (User u : userList) {
            System.out.println();
        }

        UserDAO.instance.list();
        UserDAO.instance.save(new User("", ""));
        UserDAO.instance.list();
    }
}
