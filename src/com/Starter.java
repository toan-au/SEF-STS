package com;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.model.Course;
import com.model.Storage;
import com.model.Student;
import com.model.User;

public class Starter {

	private final static String tableName = "JDBC_TEST";

	public static void main(String[] args) {
		// Connect to MySQL
//		Connection conn = null;
//		try {
//			conn = DBConnection.getConnection();
//			System.out.println("Connected to database");
//			testMethodBeforeProperImplementation(conn);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return;
//		}
		
		// add a student
		Student student1 = new Student("s1234567", "Toan", "12345", "Au", new GregorianCalendar(1993, 12, 25), "toan@au.com");
		Storage.users.add( student1) ;
		
		//add a course
		Course course1 = new Course("COSC1024", "Software Engineering Fundamentals", 4, 2016, 2);
		Storage.courses.add( course1 );
		
		System.out.println(Storage.getUser("s1234567").getName());
		System.out.println(Storage.getCourse("COSC1024").getLatestSemester());
		
		for (User user : Storage.users) {
			System.out.println(user.getId());
		}
	}

	public static void testMethodBeforeProperImplementation(Connection conn) throws SQLException {
		// Create a table
		String createString = "CREATE TABLE " + tableName + " ( " + "ID INTEGER NOT NULL, " + "NAME varchar(40) NOT NULL, "
				+ "STREET varchar(40) NOT NULL, " + "CITY varchar(20) NOT NULL, " + "STATE char(2) NOT NULL, " + "ZIP char(5), "
				+ "PRIMARY KEY (ID))";
		executeUpdate(conn, createString);
		System.out.println("Created a table");

		// Drop the table
		String dropString = "DROP TABLE " + tableName;
		executeUpdate(conn, dropString);
		System.out.println("Dropped the table");
	}

	public static boolean executeUpdate(Connection conn, String command) throws SQLException {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(command); // This will throw a SQLException if it fails
			return true;
		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

}
