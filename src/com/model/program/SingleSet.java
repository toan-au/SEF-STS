package com.model.program;

import java.util.ArrayList;

public class SingleSet {
	ArrayList<String> courses;
	String setName;

	public SingleSet(String setName) {
		this.setName = setName;
		courses = new ArrayList<>();
	}

	public String getName() {
		return setName;
	}

	public ArrayList<String> getCourses() {
		return courses;
	}

	public void add(String courseId) {
		courses.add(courseId);
	}

	public void remove(String courseId) {
		courses.remove(courseId);
		// TODO No idea if it works like that with strings...
	}

}
