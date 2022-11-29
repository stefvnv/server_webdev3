package com.example.project;

import java.sql.*;
import java.util.ArrayList;

public enum UserDAO {
    instance;

    /**
     * Connects to database
     */
    public static Connection getConnection(){
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            return DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/oneDB", "sa", "");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Checks if user attempting to login exists in database
     */
    public static User checkLogin(String email, String password){
        Connection conn = getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM USER where email ='" + email + "'");
            while (rs.next()) {
                if (rs.getString("password").equals(password)){
                    return new User(rs.getString("name"), rs.getString("email"), rs.getString("password"));
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        return null;

    }

    //CRUD
    //Create - Insert - save
    //Read - Select - list
    //Update - Update - update
    //Delete - Delete - remove

    /**
     * CREATE
     * Saves user to database
     */
    public void save(User u) throws Exception {
        Connection conn = getConnection();
        PreparedStatement psmt = conn.prepareStatement("INSERT INTO USER(name, email, password) VALUES (?,?,?)");

        psmt.setString(1, u.getName());
        psmt.setString(2, u.getEmail());
        psmt.setString(3, u.getPassword());

        psmt.executeUpdate();
        psmt.close();
        conn.close();
    }

    //Read
    public User selectOne(String email) throws Exception {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM USER where email ='" + email + "'");
        while (rs.next()) {

            if (rs.getString("email").equals(email)) {

                User u = new User(rs.getString("email"), rs.getString("name"), "blank");
                return u;
            }
        }
        return null;
    }

    //update


    /**
     * DELETE
     * Deletes user from database
     */
    public boolean deleteUser(String email) throws Exception {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        User u = selectOne(email);
        String n = u.getName();

        //if doing database correctly (foreign keys, link table between user/books etc)
        //only one query needed - removing user from user table will remove all of their objects
        //from the other tables.

        //however.... if choose to not create database with Normalization, you will need 2 queries
        //one to delete from each table individually like so.....
        //deleting user from user table
        int rs = stmt.executeUpdate("DELETE FROM USER where email= '" + email + "'");
        //deleting books from books table using name....
        int rs2 = stmt.executeUpdate("DELETE FROM Books where name= '" + n + "'");
        System.out.println(rs);
        if (rs > 0) {
            return true;
        }
        return false;
    }


    /**
     *
     */
    public ArrayList<User> list() throws Exception {
        ArrayList<User> listOfUsers = new ArrayList();
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM USER");
        while (rs.next()) {
            User u = new User("blank", rs.getString("name"), rs.getString("address"));
            listOfUsers.add(u);
        }
        return listOfUsers;
    }
}
