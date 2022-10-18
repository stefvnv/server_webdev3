package com.example.lab5_example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public enum UserDAO {
    instance;

    List<User> users;

    private UserDAO() {
        users = new ArrayList<User>(3);

        User user1 = new User("Paul", "Athlone");
        users.add(user1);

        User user2 = new User("Johnny", "New York");
        users.add(user2);

        User user3 = new User("Clementine", "Dublin");
        users.add(user3);
    }

    public List<User> list() {
        return users;
    }


    //database options
    public Connection getConnection() throws Exception {
        //load the driver class
        Class.forName("org.hsqldb.jdbcDriver");

        //get connection from DriverManager
        Connection con;
        con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "sa", "");
        return con;
    }


    //get a connection to the database and insert new user
    public void save(User user) throws Exception {

        //get the connection
        Connection connection = getConnection();

        //create prepared statement with placeholders for the parameters
        PreparedStatement psmt = connection.prepareStatement("INSERT INTO USER (name, address) VALUES(?,?)");

        //update the placeholders with the model properties
        psmt.setString(1, user.getName());
        psmt.setString(2, user.getAddress());

        //execute the statement
        psmt.executeUpdate();
    }
}
