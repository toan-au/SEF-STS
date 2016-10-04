package com.model;

import java.io.Serializable;

public class Course implements Serializable {
	private String courseId, courseName;
	private int credits;

	public Course(String courseId, String courseName, int credits) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.credits = credits;
		Storage.courses.add(this);
	}

	public String getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public int getCredits() {
		return credits;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "\n" + courseId + " " + courseName;
	}
}
