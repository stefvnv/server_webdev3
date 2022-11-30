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


    /**
     * READ
     * Checks if user attempting to log in exists in database
     */
    public static ArrayList<Grade> checkGradeValidity(User user) {
        Connection conn = UserDAO.getConnection();
        Statement stmt;

        try {
            stmt = conn.createStatement();
            ArrayList<Grade> gradesToReturn = new ArrayList<>();
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


    /**
     * UPDATE
     * Updates grade in database
     */
    public static void update(String email, String year, String module, String newGrade, int listSize) throws SQLException {
        Connection conn = UserDAO.getConnection();
        Statement stmt = conn.createStatement();


        if (listSize == 0) {
            int rs = stmt.executeUpdate("UPDATE GRADE SET Grade = '" + newGrade + "' WHERE year = '" + year + "' and module = '" + module + "'" + "and email = '" + email + "'");
            System.out.println(rs + " record updated");
        }
        for (int i = 0; i < listSize; i++) {
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


        if (listSize == 0) {
            int rs = stmt.executeUpdate("DELETE FROM GRADE where email= '" + deleteEmail + "'and module= '" + deleteMod + "'");
            System.out.println(rs + " record deleted");
        }
        for (int i = 0; i < listSize; i++) {
            int rs = stmt.executeUpdate("DELETE FROM GRADE where email= '" + deleteEmail + "'and module= '" + deleteMod + "'");
            System.out.println(rs + " record deleted");
        }
    }
}
