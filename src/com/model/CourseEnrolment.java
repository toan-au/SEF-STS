package com.model;

public class CourseEnrolment {
	
	private Student student;
	private Course course;
	private int year;
	private int semester;
	private boolean failed;
	
	public CourseEnrolment(String studentId, String courseId, int semester, int year) {
		student = (Student) Storage.getUser(studentId);
		course = Storage.getCourse(courseId);
		this.semester = semester;
		this.year = year;
		failed = false;
	}
	
	//If we want to say the student has failed that course then we indicate it with a boolean in the constructor
	public CourseEnrolment(String studentId, String courseId, int semester, int year, boolean failed) {
		student = (Student) Storage.getUser(studentId);
		course = Storage.getCourse(courseId);
		this.semester = semester;
		this.year = year;
		this.failed = failed;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public boolean isFailed() {
		return failed;
	}

	public void setFailed(boolean failed) {
		this.failed = failed;
	}


	
	
	
	
}
