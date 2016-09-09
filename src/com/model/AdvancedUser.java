package com.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Scanner;

public abstract class AdvancedUser extends User {
	
	Scanner input = new Scanner(System.in);

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
		String inputName, inputId, inputDOB, inputEmail;
		
		System.out.println("Enter the student's ID");
		inputId = input.next();
		
		System.out.println("Enter the student's Name");
		inputName = input.next();
		
		System.out.println("Enter the student's Date of birth e.g '30/12/1990'");
		inputDOB = input.next();
		
		System.out.println("Enter the student's Email");
		inputEmail = input.next();
		
		//split the inputDOB into 3 ints
		String[] stringDates = inputDOB.split("/");
		int day = Integer.parseInt(stringDates[0]);
		int month = Integer.parseInt(stringDates[1]);
		int year = Integer.parseInt(stringDates[2]);
		
		//convert inputDOB into calender
		GregorianCalendar DOB = new GregorianCalendar(year, month, day);
		
		Student newStudent = new Student(inputId, inputName, inputPassword, DOB, inputEmail);
	}

	public void createStudentAccount(ArrayList<Student> student) {

	}

	public void uploadEnrolment(Student student, Map<Course, Double> enrolments) {

	}

	public void uploadEnrolment(Map<Student, Map<Course, Double>> enrolments) {

	}
}
