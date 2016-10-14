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

	public Coordinator(String id, String name, String password) {
		super(id, name, password);
	}

	public void setCoreCourses(ArrayList<String> courses) {
		for (String courseId : courses)
			program.setCoreCourse(courseId);
	}
	
	public static void checkProgramRequirements() {
		
	}
	
	public static void checkProgramCompletion() {
		String fileName, line;
		FileInputStream fis;
		InputStreamReader isr;
		BufferedReader reader;
		int failed = 0;
		ArrayList<CourseEnrolment> enrolments = new ArrayList<>(); 
		
		System.out.println("what is the name of the file which holds the student's you want to check?");
		fileName = Global.scanner.next();
		
		try {
			fis = new FileInputStream(fileName);
			isr = new InputStreamReader(fis);
			reader = new BufferedReader(isr);
			
			while((line = reader.readLine()) != null) {
				for(CourseEnrolment enrolment : Storage.courseEnrolments) {
					if(enrolment.getStudent().getName() == line) {
						enrolments.add(enrolment);
						if(enrolment.isFailed()) {
							failed++;
						}
					}
				}
				
				if(failed>0) {
					System.out.println(line + " has failed " + failed + " courses and will need to repeat them");
				} else {
					System.out.println(line + " is currently in progress to completing the program");
				}
				
				failed = 0;
			}
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found exiting to the menu");
		} catch (IOException e) {
			System.out.println("Couldn't find the file. you're on your own buddy");
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
