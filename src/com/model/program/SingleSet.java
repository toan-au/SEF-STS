package com.model.program;

import java.io.Serializable;
import java.util.ArrayList;

import com.model.Course;

@SuppressWarnings("serial")
public class SingleSet implements Serializable {
	ArrayList<Course> courses;
	String setName;

	public SingleSet(String setName) {
		this.setName = setName;
		courses = new ArrayList<>();
	}

	public String getName() {
		return setName;
	}

	public void setName(String setName) {
		this.setName = setName;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		courses.add(course);
	}

	public void removeCourse(Course course) {
		courses.remove(course);
	}

}
