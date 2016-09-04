package com.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdvancedUserTest {

	@Test
	public void test() {
		AdvancedUser advUser = new AdvancedUser("s3514782", "Ana Teo", "password");
		String advUserId = advUser.getId();
		String advUserName = advUser.getName();
		String advUserPass = advUser.getPassword();

		assertEquals("s3514782", advUserId);
		assertEquals("Ana Teo", advUserName);
		assertEquals("password", advUserPass);

	}

}
