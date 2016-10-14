package com.model.users;

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
		Program program;

		while (loop) {
			System.out.println("Enter the ID of the program you would like to edit: ");
			idInput = Global.scanner.next();

			program = Storage.getProgram(idInput);

			if (program == null) {
				System.out.println("No program with that ID code. Please try again: ");
				continue;
			}

			do {
				// show user menu how they can edit programs
				System.out.println("How would you like to edit \"" + program.getProgramCode() + "\"");
				System.out.println("1 - Set credit points needed");
				System.out.println("2 - Set core courses");
				System.out.println("3 - Set specialization courses");
				System.out.println("4 - back");

				// get user input
				selection = Global.scanner.nextInt();

				// run a method based on user's selection
				switch (selection) {
				case 1:
					setCreditPointsNeeded(program);
					break;
				case 2:
					while (true) {
						System.out.println("Please enter the first course id, cancel by entering 'x':");
						String courseId = Global.scanner.next();
						if (courseId.equals("x"))
							break;
						program.setCoreCourse(courseId);
					}

					break;
				case 3:
					String setName;
					ArrayList<String> courses = new ArrayList<>();
					
					if (program.getSpecializationMode() == SpecializationMode.FIXEDSET) {
						System.out.println("Please specify the set you would like to add/extend:");
						setName = Global.scanner.next();
					} else {
						setName = "course pool";
					}
					while(true){
						System.out.println("Please enter the first course id, cancel by entering 'x':");
						String courseId = Global.scanner.next();
						if (courseId.equals("x"))
							break;
						courses.add(courseId);
					}
					program.setSpecializations(setName, courses);
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

	public void createStudentAccount(ArrayList<Student> student) {

	}

	public void uploadEnrolment(Student student, Map<Course, Double> enrolments) {

	}

	public void uploadEnrolment(Map<Student, Map<Course, Double>> enrolments) {

	}
}
