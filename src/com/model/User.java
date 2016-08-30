package com.model;

import java.util.Map;

public abstract class User {
	protected String name;
	protected String id;
	protected String password;
	
	//*********************************************************
	//Constructor
	//**********************************************************
	
	//Is the ID going to be generated or assigned??
	public User(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	//*********************************************************
	//Getters
	//**********************************************************
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	//*********************************************************
	//Setters
	//**********************************************************
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	//*********************************************************
	//Other
	//**********************************************************
	
	public Map<Course, Double> checkStudentResults(Student student){
		return null;
		
	}
	
	public boolean meetsCourseCompletion(Student student){
		return false;
		
	}
}
