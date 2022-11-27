package com.example.lab8;

import java.sql.*;

public enum UserDAO {
    instance;

    public static User checkLogin(String name, String password) {
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


    public User selectOne(String name) throws Exception {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM USER where name ='" + name + "'");
        while (rs.next()) {
            if (rs.getString("email").equals(name)) {

                User u = new User(rs.getString("email"), rs.getString("name"), "blank");
                return u;
            }

        }
        return null;
    }


    //get a connection to the database and insert new user

    /**
     * CREATE
     */
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


    /**
     * DELETE
     */
    public boolean deleteUser(String name) throws Exception {

        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        User u = selectOne(name);
        String n = u.getName();

        //if doing database correctly (foreign keys, link table between user/books etc)
        //only one query needed - removing user from user table will remove all of their objects
        //from the other tables.

        //however.... if choose to not create database with Normalization, you will need 2 queries
        //one to delete from each table individually like so.....
        //deleting user from user table
        int rs = stmt.executeUpdate("DELETE FROM USER where name = '" + name + "'");
        //deleting books from books table using name....
        int rs2 = stmt.executeUpdate("DELETE FROM Books where name = '" + n + "'");
        System.out.println(rs);
        if (rs > 0) {
            return true;
        }
        return false;
    }
}
