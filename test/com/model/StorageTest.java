package com.model;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

public class StorageTest {

	@Test
	public void test() {
		// add a student
		Student student1 = new Student("s1234567", "Toan", "12345", new GregorianCalendar(1993, 12, 25), "toan@au.com");
		Storage.users.add( student1) ;
		
		// add a course
		Course course1 = new Course("COSC1024", "Software Engineering Fundamentals", 4, 2016, 2);
		Storage.courses.add( course1 );
		
		// add a program
		// Program program1 = new Program();
		
		for (User user : Storage.users) {
			System.out.println(user.getId());
		}
		
		assertEquals("Toan", Storage.getUser("s1234567").getName());
		assertEquals("Software Engineering Fundamentals", Storage.getCourse("COSC1024").getCourseName());
		assertEquals("Computer Science", Storage.getProgram("BP024"));
	}

}
