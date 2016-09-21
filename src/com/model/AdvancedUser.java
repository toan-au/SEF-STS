package com.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Scanner;

import com.view.StudentProgressSystem;

public abstract class AdvancedUser extends User {


	public AdvancedUser(String id, String name, String password) {
		super(id, name, password);
	}
	
	public void editProgram() {
		boolean loop = true;
		String idInput;
		Program temp;
		
		while(loop) {
			System.out.println("Enter the ID of the course you would like to edit: ");
			idInput = StudentProgressSystem.scanner.next();
			
			temp = Storage.getProgram(idInput);
			
			if(temp == null) {
				System.out.println("No program with that ID code. Please try again: ");
				continue;
			}
		}
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
		String inputId = StudentProgressSystem.scanner.next();

		System.out.println("Enter the student's password");
		String inputPassword = StudentProgressSystem.scanner.next();

		System.out.println("Enter the student's Name");
		String inputName = StudentProgressSystem.scanner.next();

		createStudentAccount(inputId, inputPassword, inputName);
	}

	protected void createStudentAccount(String userId, String password, String fullName) {
		System.out.println("Please enter the student's birthdate (day only)");
		StudentProgressSystem.scanner.useDelimiter("/");
		int day = StudentProgressSystem.scanner.nextInt();
		System.out.println("Please enter the student's birth month");
		int month = StudentProgressSystem.scanner.nextInt();
		System.out.println("Please enter the student's birth year");
		int year = StudentProgressSystem.scanner.nextInt();
		StudentProgressSystem.scanner.reset();

		System.out.println("Please enter the student's email.");
		String email = StudentProgressSystem.scanner.next();

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
