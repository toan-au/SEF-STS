package com.model.users;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.model.Course;
import com.model.CourseEnrolment;
import com.model.Storage;
import com.model.program.Program;

@SuppressWarnings("serial")
public class Student extends User {

	private GregorianCalendar dateOfBirth;
	private String email;
	private ArrayList<CourseEnrolment> courses;
	private Program program;

	public Student(String id, String name, String password, GregorianCalendar dateOfBirth, String email) {
		super(id, name, password);
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		courses = new ArrayList<>();
		Storage.students.add(this);

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

	public void setDateOfBirth(GregorianCalendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void enrolCourse(CourseEnrolment enrolment) {
		Storage.courseEnrolments.add(enrolment);
		courses.add(enrolment);
	}

	public void enrolProgram(String programCode) {
		this.setProgram(Storage.getProgram(programCode));
	}

	@Override
	public String toString() {
		return id + " " + name + " " + dateOfBirth + " " + email;

	}

	public int getCredits() {
		// TODO Auto-generated method stub
		return 0;
	}

}
