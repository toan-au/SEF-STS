package com.model.users;

import java.io.Serializable;

import com.Global;
import com.model.Course;
import com.model.CourseEnrolment;
import com.model.Storage;

@SuppressWarnings("serial")
public abstract class User implements Serializable {
	protected String name;
	protected String id;
	protected String password;

	public User(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void checkStudentResults(String studentId) {
		System.out.println("course ID\t" + "semester\t" + "year\t" + "status");
		for (CourseEnrolment course : Storage.getStudent(studentId).getCourses()) {
			String status = course.hasPassed() ? "pass" : "failed";
			System.out.println(course.getCourse().getCourseId() + "\t" + course.getSemester() + "\t\t" + course.getYear() + "\t " + status);
		}
	}

	public static void checkStudentResults() {
		System.out.println("Enter the ID of the student you want to check");
		checkStudentResults(Global.scanner.next());
	}

	public static boolean meetsCourseCompletion(Student student, Course course) {
		return false;
	}

	@Override
	public String toString() {
		return id + " " + name;

	}

}
