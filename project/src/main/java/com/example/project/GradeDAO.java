/**
 * Model - GradeDAO
 * Stefana Chiritescu
 * A00282343
 */

package com.example.project;

import java.sql.*;
import java.util.ArrayList;

public enum GradeDAO {
    instance;


    /**
     * CREATE
     * Saves (adds) grade to database
     */
    public void save(Grade g) throws Exception {

        //connects to database, inserts statement
        Connection conn = UserDAO.getConnection();
        PreparedStatement psmt = conn.prepareStatement("INSERT INTO GRADE(year, module, grade, email) VALUES (?,?,?,?)");

        //sets parameters to values as inserted in database
        psmt.setString(1, g.getYear());
        psmt.setString(2, g.getModule());
        psmt.setString(3, g.getGrade());
        psmt.setString(4, g.getEmail());

        //executes the statement, closes connection
        psmt.executeUpdate();
        psmt.close();
        conn.close();
    }


    /**
     * READ
     * Checks if user attempting to log in exists in database
     */
    public static ArrayList<Grade> checkGradeValidity(User user) {

        //connects to database
        Connection conn = UserDAO.getConnection();
        Statement stmt;

        try {
            //creates statement
            stmt = conn.createStatement();

            //creates array list of grades to be returned
            ArrayList<Grade> gradesToReturn = new ArrayList<>();

            //executes SQL select query and stores into result set object
            ResultSet rs = stmt.executeQuery("SELECT * FROM GRADE where email ='" + user.getEmail() + "'");

            while (rs.next()) {

                //adds new grade to grade object
                gradesToReturn.add(new Grade(rs.getString("year"), rs.getString("module"), rs.getString("grade"), rs.getString("email")));
            }

            //if grades array list is empty
            if (gradesToReturn.isEmpty()) {
                return null;
            }
            return gradesToReturn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * UPDATE
     * Updates grade in database
     */
    public static void update(String email, String year, String module, String newGrade, int listSize) throws SQLException {

        //connects to database, creates statement
        Connection conn = UserDAO.getConnection();
        Statement stmt = conn.createStatement();

        //if list is empty
        if (listSize == 0) {

            //executes SQL update query and stores into result set object
            int rs = stmt.executeUpdate("UPDATE GRADE SET Grade = '" + newGrade + "' WHERE year = '" + year + "' and module = '" + module + "'" + "and email = '" + email + "'");
            System.out.println(rs + " record updated");
        }

        //iterates through each element in list
        for (int i = 0; i < listSize; i++) {

            //executes SQL select query and stores into result set object
            int rs = stmt.executeUpdate("UPDATE GRADE SET Grade = '" + newGrade + "' WHERE year = '" + year + "' and module = '" + module + "'" + "and email = '" + email + "'");
            System.out.println(rs + " record updated");
        }
    }


    /**
     * DELETE
     * Deletes grade from database
     */
    public static void delete(String deleteMod, String deleteEmail, int listSize) throws Exception {
        Connection conn = UserDAO.getConnection();
        Statement stmt = conn.createStatement();


        //if list is empty
        if (listSize == 0) {

            //executes SQL delete query and stores into result set object
            int rs = stmt.executeUpdate("DELETE FROM GRADE where email= '" + deleteEmail + "'and module= '" + deleteMod + "'");
            System.out.println(rs + " record deleted");
        }

        //iterates through each element in list
        for (int i = 0; i < listSize; i++) {

            //executes SQL delete query and stores into result set object
            int rs = stmt.executeUpdate("DELETE FROM GRADE where email= '" + deleteEmail + "'and module= '" + deleteMod + "'");
            System.out.println(rs + " record deleted");
        }
    }
}
