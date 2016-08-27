package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private static final String userName = "root";
	private static final String password = "123456";
	private static final String serverName = "localhost";
	private static final int portNumber = 3306;
	private static final String dbName = "test";
	private static Connection con = null;

	private DBConnection() {
	}

	/**
	 * Return the database connection, or opens it if it doesn't exist yet.
	 * @return Database Connection
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		if (con == null) {
			Properties conProps = new Properties();
			conProps.put("user", userName);
			conProps.put("password", password);

			con = DriverManager.getConnection("jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName, conProps);
		}
		return con;
	}

}
