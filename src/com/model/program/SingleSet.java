package com.model.program;

import java.io.Serializable;
import java.util.ArrayList;

import com.model.Course;

@SuppressWarnings("serial")
public class SingleSet implements Serializable{
	ArrayList<Course> courses;
	String setName;

	public SingleSet(String setName) {
		this.setName = setName;
		courses = new ArrayList<>();
	}

	public String getName() {
		return setName;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void add(Course course) {
		courses.add(course);
	}

	public void remove(Course course) {
		courses.remove(course);
		// TODO No idea if it works like that with strings...
	}

}
