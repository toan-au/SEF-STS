package com.model;

public class Course {
	private String courseID, courseName;
	private int credits;
	private int latestYear;
	private int latestSemester;
	
	//TEMP static variables to hold course objects
	public static Course apt = new Course("COSC1076","Advanced Programming Techniques", 4, 2016, 2);
	
	//The course Constructor.
	public Course(String courseID, String courseName, int credits, int latestYear, int latestSemester) {
		this.courseID = courseID;
		this.credits = credits;
		this.latestSemester = latestSemester;
		this.latestYear = latestYear;
	}
	
	//Getting the variables
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
	
	//Setting the course
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
	
	//Other?
}
