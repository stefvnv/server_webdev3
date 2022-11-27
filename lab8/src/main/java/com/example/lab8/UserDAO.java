package com.example.lab8;

import java.sql.*;

public enum UserDAO {
    instance;


    public static User checkLogin(String name, String password){

        return null;
    }


    //database options
    public Connection getConnection() throws Exception {

        //load the driver class
        Class.forName("org.hsqldb.jdbc.JDBCDriver");

        //get connection from DriverManager, used by save, list, update, delete methods
        Connection con;
        con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "sa", "");
        return con;
    }


    //get a connection to the database and insert new user
    public void save(User user) throws Exception {

        //get the connection
        Connection connection = getConnection();

        //create prepared statement with placeholders for the parameters
        PreparedStatement psmt = connection.prepareStatement("INSERT INTO USER (name, password, address) VALUES(?,?,?)");

        //update the placeholders with the model properties
        psmt.setString(1, user.getName());
        System.out.println("should be name " + user.getName());
        psmt.setString(2, user.getPassword());
        psmt.setString(3, user.getAddress());

        //execute the statement
        psmt.executeUpdate();
    }
}
