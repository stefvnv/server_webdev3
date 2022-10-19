package com.example.lab5_example;

import java.sql.*;
import java.util.ArrayList;

public enum UserDAO {
    instance;

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

    public ArrayList<User> list() throws Exception{

        ArrayList<User> userList = new ArrayList<>();
        Connection con = getConnection();

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT  * FROM USER");

        while (rs.next()) {
            User user = new User("name", rs.getString("name"), rs.getString("address"));
        }
        return userList;
    }
}
