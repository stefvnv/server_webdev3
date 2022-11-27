package com.example.lab5;

import java.sql.*;
import java.util.ArrayList;

public enum UserDAO {
    instance;

    //database options
    public Connection getConnection() throws Exception {
        //load the driver class
        Class.forName("org.hsqldb.jdbcDriver");

        //get connection from DriverManager

        //used by save, list, update, delete methods
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
        ArrayList<User> listOfUsers = new ArrayList();
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM USER");
        while (rs.next()) {
            User u = new User( rs.getString("name"), rs.getString("address"));
            listOfUsers.add(u);

        }
        return listOfUsers;
    }
}
