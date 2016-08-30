package com.model;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class StudentTest {

	@Test
	public void test() {
		Student s1 = new Student("s3928183", "Toan Au", "password", new Date( 1993, 12, 25), "s3589104@student.rmit.edu.au");
	}

}
