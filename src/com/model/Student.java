package com.model;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Student extends User {

	private String studentID; // there are still open discussions if studentID = User.id
	private String surname;
	private String givenNames;
	private Calendar dateOfBirth;
	private String email;
	private Map<Course, Double> courses;

	public Student(String id, String userName, String password, String surname, String givenNames, Calendar dateOfBirth, String email) {
		super(id, userName, password);
		this.setSurname(surname);
		this.setGivenNames(givenNames);
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		courses = new HashMap<Course, Double>(5);
	}

	public String getSurname() {
		return surname;
	}

	public String getGivenNames() {
		return givenNames;
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

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setGivenNames(String givenNames) {
		this.givenNames = givenNames;
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
