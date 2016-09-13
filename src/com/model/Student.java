package com.model;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Student extends User{

	private String name;
	private Calendar dateOfBirth;
	private String email;
	private Map<Course, Double> courses;
	private Program program;

	public Student(String id, String name, String password, Calendar dateOfBirth, String email) {
		super(id, name, password);
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		courses = new HashMap<Course, Double>(24);
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

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}
	
	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void enrolCourse(String courseId) {
		Course course = Storage.getCourse(courseId);
		courses.put(course, 0.0);
	}

	public void enrolProgram(String programCode) {
		this.setProgram(Storage.getProgram(programCode));
	}

	public void checkStudentResults() {
		System.out.println("Your results are:");
		for (Map.Entry<Course, Double> result : courses.entrySet()) {
			System.out.println(result.getKey().getCourseId() + " " + result.getKey().getCourseName() + " : " + result.getValue());
		}

	}

}
