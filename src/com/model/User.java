package com.model;

import java.io.Serializable;
import com.view.StudentProgressSystem;

public abstract class User implements Serializable {
	protected String name;
	protected String id;
	protected String password;

	// TODO: Is the ID going to be generated or assigned??
	public User(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
		Storage.users.add(this);
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

	public void checkStudentResults() {
		String status;
		String studentId;
		Student student;

		System.out.println("Which student would you like to check?");
		studentId = StudentProgressSystem.scanner.next();

		student = (Student) Storage.getUser(studentId);

		System.out.println("results are:");
		System.out.println("course ID \t semester \t year \t status");

		// iterate over the courses Arraylist and print the ID and status of the student
		for (int i = 0; i < student.getCourses().size(); i++) {
			// if the student has failed the course then print "failed" otherwise "pass"
			if (student.getCourses().get(i).isFailed()) {
				status = "failed";
			} else {
				status = "pass";
			}
			System.out.println(student.getCourses().get(i).getCourse().getCourseId() + "\t\t"
					+ student.getCourses().get(i).getSemester() + "\t" + student.getCourses().get(i).getYear() + "\t"
					+ status);
		}
	}

	public boolean meetsCourseCompletion(Student student, Course course) {
		return false;
	}

	public String toString() {
		return "\n" + id + " " + name;

	}

}
