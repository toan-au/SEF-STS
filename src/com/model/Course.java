package com.model;

import java.io.Serializable;

public class Course implements Serializable{
	private String courseId, courseName;
	private int credits;
	private int latestYear;
	private int latestSemester;

	public Course(String courseId, String courseName, int credits) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.credits = credits;
//		this.latestSemester = latestSemester;
//		this.latestYear = latestYear;
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

	public int getLatestYear() {
		return latestYear;
	}

	public int getLatestSemester() {
		return latestSemester;
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

	public void setLatestYear(int latestYear) {
		this.latestYear = latestYear;
	}

	public void setLatestSemester(int latestSemester) {
		this.latestSemester = latestSemester;
	}
}
