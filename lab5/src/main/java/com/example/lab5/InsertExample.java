package com.example.lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertExample {
    public static void main(String[] args) {
        try {
            String name = "john" ;
            String address = "athlone" ;

            Class.forName("org.hsqldb.jdbcDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/oneDB", "sa", "");
            Statement stmt = con.createStatement();

            stmt.executeUpdate("INSERT INTO USER (name, address)  VALUES ('john','roscommon')");

            stmt.executeUpdate("INSERT INTO USER (name, address)"
                    + "VALUES ('" + name + "','" + address + "')");

            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
