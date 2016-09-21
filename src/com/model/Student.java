package com.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.controller.Storage;

@SuppressWarnings("serial")
public class Student extends User {

	private Calendar dateOfBirth;
	private String email;
	private Map<Course, Double> courses;
	private Program program;

	public Student(String id, String name, String password, Calendar dateOfBirth, String email) {
		super(id, name, password, Role.STUDENT);
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		courses = new HashMap<Course, Double>(24);
		Storage.users.add(this);
	}

	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public Map<Course, Double> getCourses() {
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

	public void setCourse(String courseId) {
		Course course = Storage.getCourse(courseId);
		courses.put(course, 0.0);
	}

	public void setProgram(String programCode) {
		this.setProgram(Storage.getProgram(programCode));
	}

	public void checkResults() {
		System.out.println("Your results are:");
		for (Map.Entry<Course, Double> result : courses.entrySet()) {
			System.out.println(result.getKey().getCourseId() + " " + result.getKey().getCourseName() + " : " + result.getValue());
		}
	}

	public static ArrayList<Student> meetsProgramRequirement(File file, boolean meetRequirements) {
		Scanner scanner;
		ArrayList<Student> students = new ArrayList<>();
		Student tempStudent;

		try {
			scanner = new Scanner(new File("/*students.txt*/"));
			while (scanner.hasNext()) {
				tempStudent = ((Student) Storage.getUser(scanner.next()));
				if (meetRequirements == tempStudent.meetsProgramRequirements())
					students.add(tempStudent);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return students;
	}

	public void uploadEnrolment(Student student, Map<Course, Double> enrolments) {

	}

	public static void uploadEnrolment(Map<Student, Map<Course, Double>> enrolments) {

	}

	@Override
	public String toString() {
		return "\n" + id + " " + name + " " + "dateOfBirth" + " " + email;

	}

	public boolean meetsProgramRequirements() {
		// TODO Auto-generated method stub
		return false;
	}

}
