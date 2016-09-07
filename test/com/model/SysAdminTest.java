package com.model;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

public class SysAdminTest {

	SysAdmin testAdmin;

	@BeforeClass
	public void setUp() {
		testAdmin = new SysAdmin("123", "test", "test");
	}

	@Test
	public void newFacAdminTest() {
		FacAdmin testFac = new FacAdmin("124", "test", "test");
		testAdmin.setUpRoles(testFac);

		// find new user in Database. Code to do this is not yet planned out
	}

	@Test
	public void newSysAdminTest() {
		SysAdmin testSys = new SysAdmin("125", "test", "test");
		testAdmin.setUpRoles(testSys);

		// find new user in Database. Code to do this is not yet planned out
	}

	@Test
	public void newCoordinatorTest() {
		Coordinator testCoordinator = new Coordinator("126", "test", "test");
		testAdmin.setUpRoles(testCoordinator);

		// find new user in Database. Code to do this is not yet planned out
	}

	@Test
	public void newStudentTest() {
		Student testStudent = new Student("125", "test", "test", "Doe", new GregorianCalendar(01, 01, 1996), "a@b.com");
		testAdmin.setUpRoles(testStudent);

		// find new user in Database. Code to do this is not yet planned out
	}

	@Test
	public void newProgramTest() {
		Program testProgram = new Program(null, 0, 0, true, null, null, null, null);
		testAdmin.setUpNewProgram(testProgram);

		assertTrue(testProgram.getIsActive());
	}

}
