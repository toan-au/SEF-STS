package com.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Coordinator extends AdvancedUser {

	Program program;

	public Coordinator(String id, String name, String password) {
		super(id, name, password);
	}

	public void setCoreCourses(ArrayList<Course> course) {
		setCoreCourses(program, course);
	}

	public ArrayList<Student> meetsProgramRequirement(File file, boolean meetRequirements) {
		Scanner student;
		ArrayList<Student> students = new ArrayList<Student>();

		try {
			student = new Scanner(new File("/*students.txt*/"));

			while (student.hasNext()) {
				// students.add(student.next());
			}
			student.close();
			// test - Student Ana = new Student(1, 12)
			// test - students.add(Ana);
			// tempo code to get an idea of what's going to happen in this block
			for (Student s : students) {
				// if (s.getCredits() == 12)
				System.out.println("The student meets the program requirements.");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return students;
	}
}
