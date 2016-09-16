package com.view;

import java.util.Scanner;

import com.controller.Storage;
import com.model.Program;
import com.model.Role;
import com.model.Student;
import com.model.User;

public class Menu {
	private static User currentUser;
	private static Scanner scanner;

	public static void displayMenu(User user) {
		scanner = new Scanner(System.in);
		currentUser = user;

		System.out.println("Hello, " + currentUser.getName() + ". What would you like to do?");

		if (currentUser.getRole() == Role.STUDENT)
			displayStudentMenu();
		else if (currentUser.getRole() == Role.FACADMIN)
			displayFacAdminMenu();
		else if (currentUser.getRole() == Role.COORDINATOR)
			displayCoordinatorMenu();
		else if (currentUser.getRole() == Role.SYSADMIN)
			displaySysAdminMenu();
	}

	private static void displayStudentMenu() {
		while (true) {
			System.out.println("1 - Check your results\n" + "2 - log out");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				((Student) currentUser).checkResults();
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
		student.checkResults();
	}

	private static void displayCoordinatorMenu() {
		while (true) {
			System.out.println("1 - Check student results\n" + "2 - Create a student account\n" + "3 - Upload enrolment\n" + "4 - log out");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Please enter the student's id: ");
				((Student) Storage.getUser(scanner.next())).checkResults();
				break;
			case 2:
				currentUser.createAccount();
				break;
			case 3:
				// currentUser.uploadEnrolment();
				break;
			case 4:
				System.out.println("Logging out...\n");
				return;
			default:
				System.out.println("Please input a valid choice");
			}
		}

	}

	private static void displaySysAdminMenu() {
		while (true) {
			System.out.println("1 - Set up roles\n" + "2 - Set up a new program\n" + "3 - Create a student account\n" + "4 - Upload enrolment\n"
					+ "5 - log out");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				// currentUser.setUpRoles();
				break;
			case 2:
				Program temp = new Program(null, choice, choice, false, null);
				break;
			case 3:
				currentUser.createAccount();
				break;
			case 4:
				// currentUser.uploadEnrolment();
				break;
			case 5:
				System.out.println("Logging out...\n");
				return;
			default:
				System.out.println("Please input a valid choice");
			}
		}
	}

}