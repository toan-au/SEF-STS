package com.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CourseEnrolmentTest {

	@Test
	public void test() {
		CourseEnrolment e1 = new CourseEnrolment("s1111111", "COSC2102B", 1, 2016);
		CourseEnrolment e2 = new CourseEnrolment("s1111111", "AERO2394", 2, 2015);
		CourseEnrolment e3 = new CourseEnrolment("s1111111", "EEET2032", 1, 2016);
		CourseEnrolment e4 = new CourseEnrolment("s1111111", "ISYS1013", 1, 2016);
		
		assertEquals("Software Engineering Project (PtB)", e1.getCourse().getCourseName());
		assertEquals("Toan Au", e1.getStudent().getName());
	}

}
