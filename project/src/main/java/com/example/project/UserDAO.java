/**
 * Model - UserDAO
 * Stefana Chiritescu
 * A00282343
 */

package com.example.project;

import java.sql.*;
import java.util.ArrayList;

public enum UserDAO {
    instance;


    /**
     * Connects to database
     */
    public static Connection getConnection() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            return DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/oneDB", "sa", "");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * CREATE
     * Saves (adds) user to database
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


    /**
     * READ
     * Checks if user attempting to login exists in database
     */
    public static User checkLogin(String email, String password) {
        Connection conn = getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM USER where email ='" + email + "'");
            while (rs.next()) {
                if (rs.getString("password").equals(password)) {
                    return new User(rs.getString("name"), rs.getString("email"), rs.getString("password"));
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    /**
     * READ
     * Checks if user attempting to login exists in database
     */
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


    /**
     * DELETE
     * Deletes user from database
     */
    public static void delete(String email) throws Exception {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        //User u = selectOne(email);
        //String n = u.getName();

        System.out.println("trying to delete email " + email);

        int rs = stmt.executeUpdate("DELETE FROM USER where email= '" + email + "'");
        System.out.println(rs + " record deleted in user");
        rs = stmt.executeUpdate("DELETE FROM GRADE where email= '" + email + "'");
        System.out.println(rs + " record deleted in grade");


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
