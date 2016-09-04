package com.model;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class UserTest {

	@Test
	public void test() {
		User user1 = new User("s3589104", "Harold", "password");

		String user1ID = user1.getId();
		String user1Name = user1.getName();
		String user1Password = user1.getPassword();

		assertEquals("s3534987", user1ID);
		assertEquals("Harold", user1Name);
		assertEquals("password", user1Password);
	}

}
