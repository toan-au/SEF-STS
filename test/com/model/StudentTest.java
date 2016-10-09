package com.model;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import com.model.users.Student;

public class StudentTest {

	@Test
	public void test() {
		Student s1 = new Student("s3589104", "Toan Au", "password", new GregorianCalendar(1993, 12, 25), "s3589104@student.rmit.edu.au");
		String s1Name = s1.getName();
		String s1Id = s1.getId();
		String s1Password = s1.getPassword();
		Calendar s1DateOfBirth = s1.getDateOfBirth();
		String s1Email = s1.getEmail();
		// s1.checkStudentResults();
		s1.enrolCourse("hello", 2 , 2016);

		assertEquals("Toan Au", s1Name);
		assertEquals("s3589104", s1Id);
		assertEquals("password", s1Password);
		assertEquals("s3589104@student.rmit.edu.au", s1Email);
		assertEquals(new GregorianCalendar(1993, 12, 25), s1DateOfBirth);
	}

}
