package com.model.users;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map;

import com.model.Course;
import com.model.Storage;
import com.model.program.Program;
import com.model.program.SpecializationMode;
import com.Global;

@SuppressWarnings("serial")
public abstract class AdvancedUser extends User {

	public AdvancedUser(String id, String name, String password) {
		super(id, name, password);
		Storage.users.add(this);
	}

	public static void editProgram() {
		boolean loop = true;
		String idInput;
		int selection;
		Program temp;

		while (loop) {
			System.out.println("Enter the ID of the program you would like to edit: ");
			idInput = Global.scanner.next();

			temp = Storage.getProgram(idInput);

			if (temp == null) {
				System.out.println("No program with that ID code. Please try again: ");
				continue;
			}

			do {
				// show user menu how they can edit programs
				System.out.println("How would you like to edit \"" + temp.getProgramCode() + "\"");
				System.out.println("1 - Set credit points needed");
				System.out.println("2 - Set core courses");
				System.out.println("3 - Set specialization courses");
				System.out.println("4 - back");

				// get user input
				selection = Global.scanner.nextInt();

				// run a method based on user's selection
				switch (selection) {
				case 1:
					setCreditPointsNeeded(temp);
					break;
				case 2:
					// setCoreCourses();
					break;
				case 3:
					setSpecializationCourses(temp);
					break;
				case 4:
					loop = false;
					break;
				default:
					System.out.println("That isn't an option, please try again.");
					break;
				}
			} while (loop);
		}
	}

	public static void setCreditPointsNeeded(Program program) {
		int creditPoints;

		// prompt user for the credit points required
		System.out.println("How many credit points would you like " + program.getProgramCode() + " to require? ");
		creditPoints = Global.scanner.nextInt();

		// set the credit points
		program.setRequiredCredits(creditPoints);

		// give user feedback
		System.out.println(program.getProgramCode() + "'s credit points have been set to " + creditPoints);
	}

	public void setCoreCourses(Program program, ArrayList<Course> course) {

	}

	public void setSpecializationCourses(Program program, ArrayList<Course> courses, String specialization, SpecializationMode mode) {

	}

	public static void setSpecializationCourses(Program program) {

	}

	public static void createStudentAccount() {
		System.out.println("Enter the student's ID");
		String inputId = Global.scanner.next();

		System.out.println("Enter the student's password");
		String inputPassword = Global.scanner.next();

		System.out.println("Enter the student's Name");
		String inputName = Global.scanner.next();

		createStudentAccount(inputId, inputName, inputPassword);
	}

	protected static void createStudentAccount(String userId, String fullName, String password) {
		System.out.println("Please enter the student's birthdate (day only)");
		int day = Global.scanner.nextInt();
		System.out.println("Please enter the student's birth month");
		int month = Global.scanner.nextInt();
		System.out.println("Please enter the student's birth year");
		int year = Global.scanner.nextInt();
		Global.scanner.reset();

		System.out.println("Please enter the student's email.");
		String email = Global.scanner.next();

		@SuppressWarnings("unused")
		Student student = new Student(userId, fullName, password, new GregorianCalendar(year, month, day), email);

		System.out.println("You have just created an account with the user name " + userId + " and password " + password + ".\n"
				+ "This account is now ready to be used.");
	}

	public static void createStudentAccounts() {
		String fileName, userId, fullName, password, email, birthday;
		String line;
		File file;
		FileInputStream fis;
		InputStreamReader isr;
		BufferedReader reader;
		int resultDay, resultMonth, resultYear;
		resultDay = 0;
		resultMonth = 0;
		resultYear = 0;
		
		System.out.println("What is the name of your file?");
		

		fileName = Global.scanner.next();
		file = new File(fileName);

		try {
			fis = new FileInputStream(fileName);
			isr = new InputStreamReader(fis);
			reader = new BufferedReader(isr);
			//use while loop to read the line
			while((line = reader.readLine()) != null) {
				//use ":" to split the file
				String [] resultMember = line.split(":");
				//set different variables, and give them value
				userId = resultMember[0];
				fullName = resultMember[1];
				password = resultMember[2];
				birthday = resultMember[3];
				email = resultMember[4];
				
				//use "/" to split birthday
				String [] birthdayString = birthday.split("/");
				//change the type from string to int.
				resultDay = Integer.parseInt(birthdayString[0]);
				resultMonth = Integer.parseInt(birthdayString[1]);
				resultYear = Integer.parseInt(birthdayString[2]);
				
				//create new student
				@SuppressWarnings("unused")
				Student student = new Student(userId, fullName, password, new GregorianCalendar(resultYear, resultMonth, resultDay), email);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found please try again. or enter 'q' to quit");
		} catch (IOException e) {
			System.out.println("error reading the file");
		}
	}

	public void uploadEnrolment(Student student, Map<Course, Double> enrolments) {

	}

	public void uploadEnrolment(Map<Student, Map<Course, Double>> enrolments) {

	}
}
