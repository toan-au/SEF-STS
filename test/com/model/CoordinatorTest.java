package com.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.model.users.Coordinator;

public class CoordinatorTest {

	@Test
	public void test() {
		Coordinator coor = new Coordinator("s314782", "Ana Teo", "password");
		String coorId = coor.getId();
		String coorName = coor.getName();
		String coorPass = coor.getPassword();

		assertEquals("s3514782", coorId);
		assertEquals("Ana Teo", coorName);
		assertEquals("password", coorPass);
	}

}
