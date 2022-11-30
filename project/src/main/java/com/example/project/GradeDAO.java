package com.example.project;

import java.sql.*;
import java.util.ArrayList;

public enum GradeDAO {
    instance;


    /**
     * Checks if user attempting to login exists in database
     */
    public static ArrayList<Grade> checkGradeValidity(User user) {
        Connection conn = UserDAO.getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ArrayList<Grade> gradesToReturn = new ArrayList<>();
            //System.out.println("user email is " + user.getEmail());
            ResultSet rs = stmt.executeQuery("SELECT * FROM GRADE where email ='" + user.getEmail() + "'");
            while (rs.next()) {
                gradesToReturn.add(new Grade(rs.getString("year"), rs.getString("module"), rs.getString("grade"), rs.getString("email")));
            }
            if (gradesToReturn.isEmpty()) {
                System.out.println("its empty");
                return null;
            }
            System.out.println(gradesToReturn.get(0).getEmail());
            System.out.println("grades " + gradesToReturn);
            return gradesToReturn;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
    public void save(Grade g) throws Exception {
        Connection conn = UserDAO.getConnection();
        PreparedStatement psmt = conn.prepareStatement("INSERT INTO GRADE(year, module, grade, email) VALUES (?,?,?,?)");

        psmt.setString(1, g.getYear());
        psmt.setString(2, g.getModule());
        psmt.setString(3, g.getGrade());
        psmt.setString(4, g.getEmail());

        psmt.executeUpdate();
        psmt.close();
        conn.close();
    }

//    //Read
//    public User selectOne(String email) throws Exception {
//        Connection conn = getConnection();
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM USER where email ='" + email + "'");
//        while (rs.next()) {
//
//            if (rs.getString("email").equals(email)) {
//
//                User u = new User(rs.getString("email"), rs.getString("name"), "blank");
//                return u;
//            }
//        }
//        return null;
//    }
//
//    //update
//
//
    /**
     * DELETE
     * Deletes grade from database
     */
    public boolean delete(String email) throws Exception {
        Connection conn = UserDAO.getConnection();
        Statement stmt = conn.createStatement();
        //User u = selectOne(email);
        ///String n = u.getName();

        //if doing database correctly (foreign keys, link table between user/books etc)
        //only one query needed - removing user from user table will remove all of their objects
        //from the other tables.

        //however.... if choose to not create database with Normalization, you will need 2 queries
        //one to delete from each table individually like so.....
        //deleting user from user table
     //   int rs = stmt.executeUpdate("DELETE FROM USER where email= '" + email + "'");

        //System.out.println(rs);

        return false;
    }
//
//
//    /**
//     *
//     */
//    public ArrayList<Grade> list() throws Exception {
//        ArrayList<Grade> listOfGrades = new ArrayList();
//        Connection conn = getConnection();
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM USER");
//        while (rs.next()) {
//            User u = new User("blank", rs.getString("name"), rs.getString("address"));
//            listOfUsers.add(u);
//        }
//        return listOfUsers;
//    }
}
