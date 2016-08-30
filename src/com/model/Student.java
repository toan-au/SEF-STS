package com.model;

import java.util.Date;
import java.util.Map;

public class Student extends User{

	private String studentID;
	private String surname;
	private String givenNames;
	private Date dateOfBirth;
	private String emailAddress;
	private Map<Course, Double> courses;
	
	//*********************************************************
	//Constructor
	//**********************************************************
	
	public Student(String id, String name, String password, Date dateOfBirth, String email) {
		super(id, name, password);
		this.dateOfBirth = dateOfBirth;
		this.emailAddress = email;
	}
	
	//*********************************************************
	//Getters
	//**********************************************************
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public String getEmail() {
		return emailAddress;
	}
	
	//*********************************************************
	//Getters
	//**********************************************************
	
}
