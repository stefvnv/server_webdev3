package com.example.assignment;

import java.util.ArrayList;
import java.util.List;

public enum UserDAO {
    instance;

    List<User> users;

    private UserDAO(){
        users = new ArrayList<User>(3);

        User user1 = new User("Paul", "Athlone");
        users.add(user1);

        User user2 = new User("Johnny", "New York");
        users.add(user2);

        User user3 = new User("Clementine", "Dublin");
        users.add(user3);
    }

    public List <User> list(){
        return users;
    }
}
