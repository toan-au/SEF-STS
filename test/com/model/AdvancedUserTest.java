package com.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdvancedUserTest {

	@Test
	public void test() {
		AdvancedUser advUser = new AdvancedUser("s3514782","Ana Teo","password", 123, "Super special");
                String advUserId = advUser.getId();
                String advUserName = advUser.getName();
                String advUserPass = advUser.getPassword();
                int advUserCreds = advUser.getCredits();
                String advUserSpecialization = advUser.getSpecialization();
                
                assertEquals("s3514782", advUserId);
                assertEquals ("Ana Teo", advUserName);
                assertEquals("password", advUserPass);
                assertEquals(123, advUserCreds);
                assertEquals("Super special", advUserSpecialization);
                
                
                
	}

}
