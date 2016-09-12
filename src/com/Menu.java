package com;

import java.util.Scanner;

import com.model.Coordinator;
import com.model.Student;
import com.model.SysAdmin;
import com.model.User;

public class Menu {
	private static User currentUser;
	private static Scanner scanner;
	private boolean isLoggedIn;

	public Menu(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	
	
	public static void displayMenu(User user) {
		currentUser = user;
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

	private static void displayStudentMenu() {
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
				((Student) currentUser).checkStudentResults();
				break;
			case 2:
				studentFlag = false;
				break;
			default:
				System.out.println("Please input a valid choice");
			}
		}

	}

	private static void displayFacAdminMenu() {
		System.out.println("Here are your students' results...");
		// currentUser.checkStudentResults();

	}

	private static void displayCoordinatorMenu() {
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

	private static void displaySysAdminMenu() {
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