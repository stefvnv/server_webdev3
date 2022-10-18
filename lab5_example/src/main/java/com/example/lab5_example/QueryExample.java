package com.example.lab5_example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryExample {

	
	public static void main(String[] args) {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection connection = DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost/oneDB","sa", "");

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT name, address FROM USER");
			while (rs.next()) {
				String name = rs.getString("name");
				String address = rs.getString("address");
				System.out.println("Name: " + name + " Address: " + address);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
