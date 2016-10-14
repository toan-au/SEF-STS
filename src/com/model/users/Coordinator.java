package com.model.users;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.model.program.Program;

@SuppressWarnings("serial")
public class Coordinator extends AdvancedUser {

	Program program;

	public Coordinator(String id, String name, String password) {
		super(id, name, password);
	}

	public void setCoreCourses(ArrayList<String> courses) {
		for (String courseId : courses)
			program.setCoreCourse(courseId);
	}

	public static ArrayList<Student> meetsProgramRequirement(String filename, boolean meetRequirements) {
		Scanner student;
		ArrayList<Student> students = new ArrayList<>();

		try {
			student = new Scanner(new File(filename));

			while (student.hasNext()) {
				// students.add(student.next());
			}
			student.close();
			// test - Student Ana = new Student(1, 12)
			// test - students.add(Ana);
			// tempo code to get an idea of what's going to happen in this block
			for (Student s : students) {
				if (s.getCredits() == 12 && meetRequirements)
					System.out.println("The student " + s + " meets the program requirements.");
				else
					System.out.println("The student " + s + " doesn't meet the program requirements.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find the selected file.");
			e.printStackTrace();
		}

		return students;
	}
}
