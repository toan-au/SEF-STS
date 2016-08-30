package com.model;

import java.util.Date;
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
	
	public boolean enrolCourse(String courseId) {
		//find course form list of courses
		Course course = new Course();
		
		//put the course in courses variable
		courses.put(course, (double) 0);
		return true;
	}
	
	public boolean enrolProgram(String programCode) {
		
		return false;
		
	}
	
	
}
