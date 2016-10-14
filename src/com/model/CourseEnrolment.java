package com.model;

import java.io.Serializable;

import com.model.users.Student;

@SuppressWarnings("serial")
public class CourseEnrolment implements Serializable {
	private Student student;
	private Course course;
	private int year;
	private int semester;
	private boolean hasPassed;

	public CourseEnrolment(Student student, Course course, int semester, int year) {
		this.student = student;
		this.course = course;
		this.semester = semester;
		this.year = year;
		hasPassed = false;
		Storage.courseEnrolments.add(this);
	}

	public CourseEnrolment(String studentId, String courseId, int semester, int year, boolean passOrFail) {
		this((Student) Storage.getUser(studentId), Storage.getCourse(courseId), semester, year);
		hasPassed = passOrFail;
	}

	public Student getStudent() {
		return student;
	}

	public Course getCourse() {
		return course;
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

	public boolean hasPassed() {
		return hasPassed;
	}

	public void setHasPassed(boolean passedOrFailed) {
		this.hasPassed = passedOrFailed;
	}

	@Override
	public String toString() {
		return student.getId() + " " + course.getCourseId() + " " + year + " " + semester + " " + hasPassed;
	}

}
