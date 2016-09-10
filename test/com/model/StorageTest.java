package com.model;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

public class StorageTest {

	@Test
	public void test() {
		// add a student
		Student student1 = new Student("s1111111", "Toan Au", "password", new GregorianCalendar(1993, 12, 25), "toan@email.com");
		Student student2 = new Student("s2222222", "Bob Builder", "password", new GregorianCalendar(1990, 1, 1), "bob@email.com");
		Student student3 = new Student("s3333333", "Harold Senpai", "password", new GregorianCalendar(1999, 6, 13), "harold@email.com");
		Student student4 = new Student("s4444444", "Sophie Au", "password", new GregorianCalendar(1800, 5, 25), "sophie@email.com");
		Student student5 = new Student("s5555555", "Ana Teo", "password", new GregorianCalendar(1700, 12, 12), "ana@email.com");
		Student student6 = new Student("s6666666", "Julie Nguyen", "password", new GregorianCalendar(0001, 1, 1), "julie@email.com");
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
