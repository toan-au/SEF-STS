package com.controller;

import static org.junit.Assert.*;
import org.junit.Test;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionTest {

	@Test
	public void connectionExistsTest() throws SQLException {
		Connection con = DBConnection.getConnection();
		assertNotNull(con);
	}

}
