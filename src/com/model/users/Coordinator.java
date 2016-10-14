package com.model.users;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.Global;
import com.model.CourseEnrolment;
import com.model.Storage;
import com.model.program.Program;

@SuppressWarnings("serial")
public class Coordinator extends AdvancedUser {

	Program program;

	public Coordinator(String id, String name, String password, String programId) {
		super(id, name, password);
		program = Storage.getProgram(programId);
	}

	public static void checkProgramRequirements() {
	}

	@SuppressWarnings("resource")
	public static void checkProgramCompletion() {
		String fileName, line;
		BufferedReader reader = null;
		int failed = 0;
		ArrayList<CourseEnrolment> enrolments = new ArrayList<>();

		System.out.println("What is the name of the file which holds the students you want to check?");
		fileName = Global.scanner.next();
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

			while ((line = reader.readLine()) != null) {
				for (CourseEnrolment enrolment : Storage.courseEnrolments) {
					if (line == enrolment.getStudent().getName() && !enrolment.hasPassed()) {
						enrolments.add(enrolment);
						failed++;
					}
				}
				if (failed > 0)
					System.out.println(line + " has failed " + failed + " courses and will need to repeat them");
				else
					System.out.println(line + " is currently on track to completing the program");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found exiting to the menu");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not load the file.");
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println("Couldn't close reader");
					e.printStackTrace();
				}
			}
		}
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
