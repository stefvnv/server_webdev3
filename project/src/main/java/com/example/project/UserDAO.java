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
            return DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "sa", "");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * CREATE
     * Saves (adds) user to database
     */
    public void save(User u) throws Exception {

        //connects to database, inserts statement
        Connection conn = getConnection();
        PreparedStatement psmt = conn.prepareStatement("INSERT INTO USER(name, email, password) VALUES (?,?,?)");

        //sets parameters to values as inserted in database
        psmt.setString(1, u.getName());
        psmt.setString(2, u.getEmail());
        psmt.setString(3, u.getPassword());

        //executes the statement, closes connects
        psmt.executeUpdate();
        psmt.close();
        conn.close();
    }


    /**
     * READ
     * Checks if user attempting to login exists in database
     */
    public static User checkLogin(String email, String password) {

        //connects to database
        Connection conn = getConnection();
        Statement stmt = null;

        try {
            //creates statenent
            stmt = conn.createStatement();

            //executes SQL select query and stores into result set object
            ResultSet rs = stmt.executeQuery("SELECT * FROM USER where email ='" + email + "'");

            while (rs.next()) {

                //checks password
                if (rs.getString("password").equals(password)) {

                    //returns new user
                    return new User(rs.getString("name"), rs.getString("email"), rs.getString("password"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    /**
     * DELETE
     * Deletes user from database
     */
    public static void delete(String email) throws Exception {

        //connects to database, creates statement
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();

        //executes SQL delete query and stores into result set object
        int rs = stmt.executeUpdate("DELETE FROM USER where email= '" + email + "'");
        System.out.println(rs + " record deleted in user");

        //executes SQL delete query and stores into result set object
        rs = stmt.executeUpdate("DELETE FROM GRADE where email= '" + email + "'");
        System.out.println(rs + " record deleted in grade");
    }
}
