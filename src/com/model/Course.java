package com.model;

public class Course {
	private String courseID, courseName;
	private int credits;
	private int latestYear;
	private int latestSemester;

	public Course(String courseID, String courseName, int credits, int latestYear, int latestSemester) {
		this.courseID = courseID;
		this.courseName = courseName;
		this.credits = credits;
		this.latestSemester = latestSemester;
		this.latestYear = latestYear;
	}

	public String getCourseID() {
		return courseID;
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

	public void setCourseID(String courseID) {
		this.courseID = courseID;
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
