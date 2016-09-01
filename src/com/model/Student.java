package com.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Student extends User{

	private String studentID;
	private String surname;
	private String givenNames;
	private Date dateOfBirth;
	private String email;
	private Map<Course, Double> courses;
	
	//*********************************************************
	//Constructor
	//**********************************************************
	
	public Student(String id, String name, String password, Date dateOfBirth, String email) {
		super(id, name, password);
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		courses = new HashMap<Course, Double>(5);
	}
	
	//*********************************************************
	//Getters
	//**********************************************************
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Map<Course, Double> getCourses() {
		return courses;
	}
	
	//*********************************************************
	//Setters
	//**********************************************************
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	//*********************************************************
	//Enrol in a course / program
	//**********************************************************
	
	public void enrolCourse(String courseId) {
		//find course form list of courses
		Course course = Course.apt;
		
		//put the course in courses variable
		courses.put(course, (double)0);
	}
	
	public boolean enrolProgram(String programCode) {
		
		return false;
		
	}
	
	public Map<Course, Double> checkStudentResults() {
		return courses;
	}
	
	
}
