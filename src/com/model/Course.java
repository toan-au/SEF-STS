package com.model;

public class Course {
	private String courseID;
	private int credits;
	private int latestYear;
	private int latestSemester;
	
	//The course Constructor.
	public Course(String courseID, int credits) {
		this.courseID = courseID;
		this.credits = credits;
	}
	
	//Getting the variables
	public String getCourseID() {
		return courseID;
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
	
	//Setting the course
	public void setCourseID(String courseID) {
		this.courseID = courseID;
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
	
	//Other?
}
