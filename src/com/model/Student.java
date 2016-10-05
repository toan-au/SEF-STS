package com.model;

import java.util.ArrayList;
import java.util.Calendar;

public class Student extends User {

	private Calendar dateOfBirth;
	private String email;
	private ArrayList<CourseEnrolment> courses;
	private Program program;

	public Student(String id, String name, String password, Calendar dateOfBirth, String email) {
		super(id, name, password);
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		courses = new ArrayList<>();
	}

	public String getGivenNames() {
		return name;
	}

	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public ArrayList<CourseEnrolment> getCourses() {
		return courses;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void enrolCourse(String courseId, int semester, int year) {
		Course course = Storage.getCourse(courseId);

		CourseEnrolment enrolment = new CourseEnrolment(this, course, semester, year);
		Storage.courseEnrolments.add(enrolment);
		courses.add(enrolment);
	}

	public void enrolProgram(String programCode) {
		this.setProgram(Storage.getProgram(programCode));
	}

	public static void checkStudentResults(Student student) {
		String status;
		System.out.println("Your results are:");
		System.out.println("course ID \t semester \t year \t status");

		// iterate over the courses Arraylist and print the ID and status of the student
		for (int i = 0; i < student.courses.size(); i++) {
			// if the student has failed the course then print "failed" otherwise "pass"
			if (student.courses.get(i).isFailed()) {
				status = "failed";
			} else {
				status = "pass";
			}
			System.out.println(student.courses.get(i).getCourse().getCourseId() + "\t\t" + student.courses.get(i).getSemester() + "\t"
					+ student.courses.get(i).getYear() + "\t" + status);
		}
	}

	@Override
	public String toString() {
		return "\n" + id + " " + name + " " + "dateOfBirth" + " " + email;

	}

	/**
	 * @return
	 */
	public int getCredits() {
		// TODO Auto-generated method stub
		return 0;
	}

}
