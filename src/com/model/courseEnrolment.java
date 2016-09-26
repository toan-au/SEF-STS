package com.model;

public class courseEnrolment {
	
	private Student student;
	private Course course;
	private int year;
	private int semester;
	private boolean failed;
	
	
	public courseEnrolment(String studentId, String courseId, int semester, int year) {
		student = (Student) Storage.getUser(studentId);
		course = Storage.getCourse(courseId);
		this.semester = semester;
		this.year = year;
		failed = false;
	}
	
	//If we want to say the student has failed that course then we indicate it with a boolean in the constructor
	public courseEnrolment(String studentId, String courseId, int semester, int year, boolean failed) {
		student = (Student) Storage.getUser(studentId);
		course = Storage.getCourse(courseId);
		this.semester = semester;
		this.year = year;
		this.failed = failed;
	}
	
	
}
