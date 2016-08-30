package com;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.controller.DBConnection;

public class Starter {

	/** The name of the table we are testing with */
	private final static String tableName = "JDBC_TEST";

	private static boolean isSetUp = true;
	
	/**
	 * Run a SQL command which does not return a recordset: CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException
	 *             If something goes wrong
	 */
	public static boolean executeUpdate(Connection conn, String command) throws SQLException {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(command); // This will throw a SQLException if it fails
			return true;
		} finally {

			// This will run whether we throw an exception or not
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	/**
	 * Connect to the DB and do some stuff
	 */
	public static void main(String[] args) {
		// Connect to MySQL
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}

		// Create a table
		try {
			String createString = "CREATE TABLE " + tableName + " ( " + "ID INTEGER NOT NULL, " + "NAME varchar(40) NOT NULL, "
					+ "STREET varchar(40) NOT NULL, " + "CITY varchar(20) NOT NULL, " + "STATE char(2) NOT NULL, " + "ZIP char(5), "
					+ "PRIMARY KEY (ID))";
			executeUpdate(conn, createString);
			System.out.println("Created a table");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			e.printStackTrace();
			return;
		}

		// Drop the table
		try {
			String dropString = "DROP TABLE " + tableName;
			executeUpdate(conn, dropString);
			System.out.println("Dropped the table");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not drop the table");
			e.printStackTrace();
			return;
		}
		
	}

}
