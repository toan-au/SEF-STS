package com.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Scanner;

public abstract class AdvancedUser extends User {

	Scanner scanner = new Scanner(System.in);

	public AdvancedUser(String id, String name, String password) {
		super(id, name, password);
	}

	public void setCreditPointsNeeded(Program program, int credits) {

	}

	public void setCoreCourses(Program program, ArrayList<Course> course) {

	}

	public void setSpecializationCourses(Program program, ArrayList<Course> courses, String specialization, SpecializationMode mode) {

	}

	public void setSpecializationCourses(Program program, ArrayList<Course> courses, String specialization) {

	}

	public void createStudentAccount() {
		System.out.println("Enter the student's ID");
		String inputId = scanner.next();

		System.out.println("Enter the student's password");
		String inputPassword = scanner.next();

		System.out.println("Enter the student's Name");
		String inputName = scanner.next();

		createStudentAccount(inputId, inputPassword, inputName);
	}

	protected void createStudentAccount(String userId, String password, String fullName) {
		System.out.println("Please enter the student's birthday like so: DD/MM/YYYY");
		scanner.useDelimiter("/");
		int day = scanner.nextInt();
		int month = scanner.nextInt();
		int year = scanner.nextInt();
		scanner.reset();

		System.out.println("Please enter the student's email.");
		String email = scanner.next();

		@SuppressWarnings("unused")
		Student student = new Student(userId, fullName, password, new GregorianCalendar(year, month, day), email);

		System.out.println("You have just created an account with the user name " + userId + "and password " + password + ".\n"
				+ "This account is now ready to be used.");
	}

	public void createStudentAccount(ArrayList<Student> student) {

	}

	public void uploadEnrolment(Student student, Map<Course, Double> enrolments) {

	}

	public void uploadEnrolment(Map<Student, Map<Course, Double>> enrolments) {

	}
}
