package com.model;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

public class SysAdminTest {

	SysAdmin testAdmin;

	@BeforeClass
	public void setUp(){
		testAdmin = new SysAdmin("123", "test", "test");
	}

	@Test
	public void newFacAdminTest() {
		FacAdmin testFac = new FacAdmin("124", "test", "test");
		
	}

	@Test
	public void newSysAdminTest() {
		SysAdmin testFac = new SysAdmin("125", "test", "test");
		
	}

	@Test
	public void newCoordinatorTest() {
		Coordinator testCoordinator = new Coordinator("126", "test", "test");
		
	}

	//this test will fail as the Date data type in Student is deprecated (to be replaced by Calendar)
	@Test
	public void newStudentTest() {
		Student testStudent = new Student("125", "test", "test", new Calendar().set(01, 01, 1996), "a@b.com");
		
	}
	
	@Test
	public void newProgramTest() {
		Program testProgram = new Program();
		testAdmin.setUpNewProgram(testProgram);
		
		assertTrue(testProgram.getIsActive());
	}

}
