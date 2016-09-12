package com;

import java.util.GregorianCalendar;
import java.util.Scanner;

import com.model.Coordinator;
import com.model.FacAdmin;
import com.model.Storage;
import com.model.Student;
import com.model.SysAdmin;
import com.model.User;

public class StudentProgressSystem {

	User currentUser;
	Scanner scanner;
	boolean isLoggedIn = false;

	public StudentProgressSystem() {
		Storage.init();
	}

	private void fancyAdminMode() {
		System.out.println("fancy admin mode activated");

		System.out.println("Create a new User Account:\n" + "Please add an Id:");
		String userId = scanner.next();
		System.out.println("Please add a password:");
		String password = scanner.next();
		System.out.println("Please add the user's name:");
		String fullName = scanner.nextLine();

		if (userId.startsWith("a")) {
			Storage.users.add(new SysAdmin(userId, fullName, password));

		} else if (userId.startsWith("c")) {
			Storage.users.add(new Coordinator(userId, fullName, password));

		} else if (userId.startsWith("f")) {
			Storage.users.add(new FacAdmin(userId, fullName, password));

		} else if (userId.startsWith("s")) {

			System.out.println("Please enter the student's birthday like so: DD/MM/YYYY");
			scanner.useDelimiter("/");
			int day = scanner.nextInt();
			int month = scanner.nextInt();
			int year = scanner.nextInt();
			scanner.reset();

			System.out.println("Please enter the student's email.");
			String email = scanner.next();

			Storage.users.add(new Student(userId, fullName, password, new GregorianCalendar(year, month, day), email));
		} else {
			System.out.println("The account name you have entered is not valid");
			return;
		}

		System.out.println("You have just created an account with the user name " + userId + "and password " + password + ".\n"
				+ "This account is now ready to be used.\n" + "You will now be taken back to the main menu...");
	}

	public void run() {
		scanner = new Scanner(System.in);

		System.out.println("Welcome to this thing. Press Enter to begin.");
		if (scanner.nextLine().equals("UpUpDownDownLeftRightLeftRightBA"))
			fancyAdminMode();

		logIn();
		displayMenu();
		scanner.close();
	}

	private void logIn() {
		User tempUser;

		System.out.println("Please enter your account details");
		while (!isLoggedIn) {
			System.out.println("ID: ");
			String inputId = scanner.nextLine();
			tempUser = Storage.getUser(inputId);
			System.out.println(inputId);
			if (tempUser == null) {
				System.out.println("The ID you entered does not exist. Please try again");
				continue;
			}

			System.out.println("Password: ");
			String passwordEntry = scanner.nextLine();
			if (!tempUser.getPassword().equals(passwordEntry)) {
				System.out.println("The Password you entered does not match the ID. Please try again");
				continue;
			}

			currentUser = tempUser;
			System.out.println("Logging in...");
			isLoggedIn = true;
		}
	}

	private void displayMenu() {
		String userId = currentUser.getId();

		System.out.println("Hello, " + userId + ". What would you like to do?");

		if (userId.startsWith("s"))
			displayStudentMenu();
		else if (userId.startsWith("f"))
			displayFacAdminMenu();
		else if (userId.startsWith("c"))
			displayCoordinatorMenu();
		else if (userId.startsWith("a"))
			displaySysAdminMenu();
	}

	private void displayStudentMenu() {
		System.out.println("1 - Check your results\n");
		System.out.println("2 - log out\n");
		System.out.println("Hello, ." + currentUser.getId() + " What would you like to do?");
		System.out.println("1 - Check your results");
		System.out.println("2 - log out");
		int choice = scanner.nextInt();

		// set a flag for continue run the loop until log out.
		boolean studentFlag = true;
		while (studentFlag) {
			switch (choice) {
			case 1:
				System.out.println("Here are your results...");
				((Student)currentUser).checkStudentResults();
				break;
			case 2:
				studentFlag = false;
				break;
			default:
				System.out.println("Please input a valid choice");
			}
		}

	}

	private void displayFacAdminMenu() {
		System.out.println("Here are your students' results...");
		// currentUser.checkStudentResults();

	}

	private void displayCoordinatorMenu() {
		// System.out.println("1.) Check student results\n" + "2.) Create a student account\n" +
		// "3.) Upload enrolment");
		System.out.println("1 - Check student results\n");
		System.out.println("2 - Create a student account\n");
		System.out.println("3 - Upload enrolment\n");
		System.out.println("4 - log out\n");
		int choice = scanner.nextInt();

		// set a flag for continue run the loop until log out.
		boolean coordinatorFlag = true;
		while (coordinatorFlag) {
			switch (choice) {
			case 1:
				// currentUser.checkStudentResults();
				break;
			case 2:
				((Coordinator) currentUser).createStudentAccount();
				break;
			case 3:
				// currentUser.uploadEnrolment();
				break;
			case 4:
				coordinatorFlag = false;
				break;
			default:
				System.out.println("Please input a valid choice");
			}
		}

	}

	private void displaySysAdminMenu() {
		// boolean to determine if we should loop
		boolean loop = true;

		while (loop) {
			System.out.println("1 - Set up roles");
			System.out.println("2 - Set up a new program");
			System.out.println("3 - Create a student account");
			System.out.println("4 - Upload enrolment");
			System.out.println("5 - log out");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				// currentUser.setUpRoles();
				break;
			case 2:
				((SysAdmin) currentUser).setUpNewProgram();
				break;
			case 3:
				((SysAdmin) currentUser).createStudentAccount();
				break;
			case 4:
				// currentUser.uploadEnrolment();
				break;
			case 5:
				System.out.println("Logging out...\n");
				loop = false;
				break;
			default:
				System.out.println("Please input a valid choice");
			}
		}
	}

}
