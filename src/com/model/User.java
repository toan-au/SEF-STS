package com.model;

import java.util.Map;

public abstract class User {
	private String name;
	private String id;
	private String password;
	
	
	public Map<Course, Double> checkStudentResults(Student student){
		return null;
		
	}
	
	public boolean meetsCourseCompletion(Student student){
		return false;
		
	}
}
