package com;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.*;

import com.controller.DBConnection;

public class StarterTest {

	Connection conn;

	@BeforeClass
	public void getConnection() throws SQLException {
		conn = DBConnection.getConnection();
	}

	@Test(expected = SQLException.class)
	public void dropNonExistentTableTest() throws SQLException {

//		Starter.executeUpdate(conn, "DROP TABLE blub");
	}

}
