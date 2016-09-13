package com.model;

import java.io.Serializable;
import java.util.Map;

public abstract class User implements Serializable {
	protected String name;
	protected String id;
	protected String password;

	// TODO: Is the ID going to be generated or assigned??
	public User(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
		Storage.users.add(this);
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<Course, Double> checkStudentResults(Student student) {
		return student.getCourses();
	}

	public boolean meetsCourseCompletion(Student student, Course course) {
		return false;
	}
}
