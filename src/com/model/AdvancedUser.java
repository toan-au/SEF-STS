package com.model;

import java.util.ArrayList;
import java.util.Calendar;
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
		int selection;
		Program temp;
		
		while(loop) {
			System.out.println("Enter the ID of the program you would like to edit: ");
			idInput = StudentProgressSystem.scanner.next();
			
			temp = Storage.getProgram(idInput);
			
			if(temp == null) {
				System.out.println("No program with that ID code. Please try again: ");
				continue;
			}
			
			do {
				//show user menu how they can edit programs
				System.out.println("How would you like to edit \"" + temp.getProgramCode() + "\"");
				System.out.println("1 - Set credit points needed");
				System.out.println("2 - Set core courses");
				System.out.println("3 - Set specialization courses");
				System.out.println("4 - back");
				
				//get user input
				selection = StudentProgressSystem.scanner.nextInt();
				
				//run a method based on user's selection
				switch(selection) {
				case 1:
					setCreditPointsNeeded(temp);
					break;
				case 2:
					//setCoreCourses();
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
			} while(loop);
		}
	}

	public void setCreditPointsNeeded(Program program) {
		int creditPoints;
		
		//prompt user for the credit points required
		System.out.println("How many credit points would you like " + program.getProgramCode() +" to require? ");
		creditPoints = StudentProgressSystem.scanner.nextInt();
		
		//set the credit points
		program.setRequiredCredits(creditPoints);
		
		//give user feedback
		System.out.println(program.getProgramCode() + "'s credit points have been set to " + creditPoints);
	}

	public void setCoreCourses(Program program, ArrayList<Course> course) {

	}

	public void setSpecializationCourses(Program program, ArrayList<Course> courses, String specialization, SpecializationMode mode) {

	}

	public void setSpecializationCourses(Program program) {

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
	
	protected void updateStudentAccount(String userId, String password, String fullName) {
		String idInput, passwordInput, nameInput;
		User userCheck;
		int dayInput, monthInput, yearInput, updateInput;
		boolean checkInputFlag, updateFlat;
		//two flag for loop
		updateFlat = true;
		checkInputFlag = true;
		//Check user is exist or not.
		while(checkInputFlag){
			System.out.println("Please enter the student's id that you want to change, or input exit to quit.");
			idInput = StudentProgressSystem.scanner.next();
			userCheck = Storage.getUser(idInput);
			if (userCheck != null){
				checkInputFlag = false;
			}else if (idInput == "exit"){
				checkInputFlag = false;
				updateFlat = false;
				System.out.println("Exit Update function");
			}else{
				System.out.println("This user is not exist, please input an exist user.");
			}
		}
		
		
		//Using while loop to change the user's detail until exit.
		while(updateFlat){
			System.out.println("Which part you want to change?");
			System.out.println("1.Email");
			System.out.println("2.userId");
			System.out.println("3.Password");
			System.out.println("4.fullName");
			System.out.println("5.exit");
			updateInput = StudentProgressSystem.scanner.nextInt();
			
			if (updateInput == 1){
				//get user input
				System.out.println("Please enter the student's birthdate (day only)");
				StudentProgressSystem.scanner.useDelimiter("/");
				dayInput = StudentProgressSystem.scanner.nextInt();
				System.out.println("Please enter the student's birth month");
				monthInput = StudentProgressSystem.scanner.nextInt();
				System.out.println("Please enter the student's birth year");
				yearInput = StudentProgressSystem.scanner.nextInt();
				StudentProgressSystem.scanner.reset();
				//update the birthday
				setDateOfBirth(new GregorianCalendar(yearInput, monthInput, dayInput));
				
			}else if (updateInput == 2){
				//update the user id
				System.out.println("Please enter the student's id");
				idInput = StudentProgressSystem.scanner.next();
				setId(idInput);
				
			}else if (updateInput == 3){
				//update the password
				System.out.println("Enter the student's password");
				passwordInput = StudentProgressSystem.scanner.next();
				setPassword(passwordInput);
				
			}else if (updateInput == 4){
				//update user's name
				System.out.println("Enter the student's Name");
				nameInput = StudentProgressSystem.scanner.next();
				setName(nameInput);
				
			}else if (updateInput == 5){
				//exit the function
				updateFlat = false;
				System.out.println("Exit Update function");
				
			}else{
				
				System.out.println("Invalid input, please input number from 1 to 5.");
			}
		}
		
		
		

		System.out.println("Please enter the student's email.");
		String email = StudentProgressSystem.scanner.next();
	}
	
}
