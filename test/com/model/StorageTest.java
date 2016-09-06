package com.model;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

public class StorageTest {

	@Test
	public void test() {
		Student student1 = new Student("s1234567", "Toan", "12345", "Au", new GregorianCalendar(1993, 12, 25), "toan@au.com");
		Storage.users.add( student1) ;
		
		//add a course
		Course course1 = new Course("COSC1024", "Software Engineering Fundamentals", 4, 2016, 2);
		Storage.courses.add( course1 );
		
		System.out.println(Storage.getUser("s1234567").getName());
		System.out.println(Storage.getCourse("COSC1024").getLatestSemester());
		
		for (User user : Storage.users) {
			System.out.println(user.getId());
		}
		
		
	}

}
