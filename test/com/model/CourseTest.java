package com.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CourseTest {

	@Test
	public void test() {
		Course course1 = new Course("ISYS1118", "Software Engineering Fundamentals", 12, 2016, 1);
		String course1Name = course1.getCourseID();
		int course1Credit = course1.getCredits();
		int course1LatestYear = course1.getLatestYear();
		int course1LatestSemester = course1.getLatestSemester();
		
		assertEquals("ISYS1118", course1Name);
		assertEquals(12, course1Credit);
		assertEquals(2016, course1LatestYear);
		assertEquals(1, course1LatestSemester);
	}

}
