package com.model;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Student extends User {

	private String name;
	private Calendar dateOfBirth;
	private String email;
	private Map<Course, Double> courses;

	public Student(String id, String name, String password, Calendar dateOfBirth, String email) {
		super(id, name, password);
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		courses = new HashMap<Course, Double>(5);
	}

	public String getGivenNames() {
		return name;
	}

	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public Map<Course, Double> getCourses() {
		return courses;
	}

	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void enrolCourse(String courseId) {
		// courses.put(findCourseById(courseId, 0.0);
	}

	public boolean enrolProgram(String programCode) {

		return false;
	}

	public Map<Course, Double> checkStudentResults() {
		return courses;
	}
}
