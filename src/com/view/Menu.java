package com.view;

import java.util.Scanner;

import com.model.Coordinator;
import com.model.Storage;
import com.model.Student;
import com.model.SysAdmin;
import com.model.User;

public class Menu {
	private static User currentUser;
	private static Scanner scanner;

	public static void displayMenu(User user) {
		scanner = new Scanner(System.in);
		currentUser = user;
		String userId = currentUser.getId();

		System.out.println("Hello, " + currentUser.getName() + ". What would you like to do?");

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
		while (true) {
			System.out.println("1 - Check your results\n" + "2 - log out");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				((Student) currentUser).checkStudentResults();
				break;
			case 2:
				System.out.println("Logging out...\n");
				return;
			default:
				System.out.println("Please input a valid choice");
			}
			System.out.println("\n");
		}

	}

	private static void displayFacAdminMenu() {
		System.out.println("Please enter a student id:");
		Student student = (Student) Storage.getUser(scanner.nextLine());
		System.out.println("Here are your students' results...");
		student.checkStudentResults();
	}

	private static void displayCoordinatorMenu() {
		while (true) {
			System.out.println("1 - Check student results");
			System.out.println("2 - Create a student account"); 
			System.out.println("3 - Upload multiple student accounts");
			System.out.println("4 - Edit Program");
			System.out.println("5 - log out");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				// currentUser.checkStudentResults();
				break;
			case 2:
				((Coordinator) currentUser).createStudentAccount();
				break;
			case 3:
				((Coordinator)currentUser).createStudentAccounts();
			case 4:
				// currentUser.uploadEnrolment();
				break;
			case 5:
				((Coordinator)currentUser).editProgram();
				break;
			case 6:
				System.out.println("Logging out...\n");
				return;
			default:
				System.out.println("Please input a valid choice");
			}
		}

	}

	private static void displaySysAdminMenu() {
		while (true) {
			System.out.println("1 - Set up roles");
			System.out.println("2 - Set up new program");
			System.out.println("3 - Create student account");
			System.out.println("4 - Upload multiple student accounts");
			System.out.println("5 - Edit a Program");
			System.out.println("6 - log out");

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
				((SysAdmin) currentUser).createStudentAccounts();
				break;
			case 5:
				((SysAdmin)currentUser).editProgram();
				break;
			case 6:
				System.out.println("Logging out...\n");
				return;
			default:
				System.out.println("Please input a valid choice");
			}
		}
	}

}