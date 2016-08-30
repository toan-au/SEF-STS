package com.model;

import java.util.Map;

public abstract class User {
	private String name;
	private String id;
	private String password;
	
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
