package com.view;

import com.Global;
import com.model.Storage;
import com.model.users.AdvancedUser;
import com.model.users.SysAdmin;
import com.model.users.User;

public class Menu {

	public static void displayMenu(String userId) {
		if (userId.startsWith("s"))
			displayStudentMenu(userId);
		else if (userId.startsWith("f"))
			displayFacAdminMenu(userId);
		else if (userId.startsWith("c"))
			displayCoordinatorMenu(userId);
		else if (userId.startsWith("a"))
			displaySysAdminMenu(userId);
	}

	private static void displayStudentMenu(String userId) {
		System.out.println("Hello, " + Storage.getStudent(userId).getName() + ". What would you like to do?");
		while (true) {
			System.out.println("1 - Check your results\n" + "2 - log out");
			int choice = Integer.parseInt(Global.scanner.next());

			switch (choice) {
			case 1:
				System.out.println("Your results are:");
				User.checkStudentResults(userId);
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

	private static void displayFacAdminMenu(String userId) {
		System.out.println("Hello, " + Storage.getUser(userId).getName() + ". Please enter a student id:");
		String studentId = Global.scanner.nextLine();

		System.out.println("Here are " + Storage.getUser(studentId) + "'s results...");
		User.checkStudentResults(studentId);

		while (true) {
			System.out.println("Want to see another student's results? Y/N");
			String choice = Global.scanner.next().toUpperCase();

			switch (choice) {
			case "J":
				System.out.println("Please enter a student id:");
				studentId = Global.scanner.nextLine();
				System.out.println("Here are " + Storage.getUser(studentId) + "'s results...");
				User.checkStudentResults(studentId);
				break;
			case "N":
				System.out.println("Logging out...\n");
				return;
			default:
				System.out.println("Come on...");
				break;
			}
		}
	}

	private static void displayCoordinatorMenu(String userId) {
		System.out.println("Hello, " + Storage.getUser(userId).getName() + ". What would you like to do?");
		while (true) {
			System.out.println("1 - Check student results");
			System.out.println("2 - Create a student account");
			System.out.println("3 - upload student accounts");
			System.out.println("4 - Upload enrolment");
			System.out.println("5 - Edit Program");
			System.out.println("6 - log out");
			int choice = Integer.parseInt(Global.scanner.next());

			switch (choice) {
			case 1:
				// currentUser.checkStudentResults();
				break;
			case 2:
				AdvancedUser.createStudentAccount();
				break;
			case 3:
				AdvancedUser.createStudentAccounts();
				break;
			case 4:
				// currentUser.uploadEnrolment();
				break;
			case 5:
				AdvancedUser.editProgram();
				break;
			case 6:
				System.out.println("Logging out...\n");
				return;
			default:
				System.out.println("Please input a valid choice");
			}
		}
	}

	private static void displaySysAdminMenu(String userId) {
		System.out.println("Hello, " + Storage.getUser(userId).getName() + ". What would you like to do?");

		while (true) {
			System.out.println("1 - Set up roles");
			System.out.println("2 - Set up new program");
			System.out.println("3 - Create student account");
			System.out.println("4 - Upload student accounts");
			System.out.println("5 - Upload Enrolments");
			System.out.println("6 - Edit a Program");
			System.out.println("7 - log out");

			int choice = Integer.parseInt(Global.scanner.next());
			switch (choice) {
			case 1:
				SysAdmin.createAccount();
				break;
			case 2:
				SysAdmin.setUpNewProgram();
				break;
			case 3:
				AdvancedUser.createStudentAccount();
				break;
			case 4:
				AdvancedUser.createStudentAccounts();
				break;
			case 5:
				// AdvancedUser.uploadEnrolments();
				break;
			case 6:
				AdvancedUser.editProgram();
				break;
			case 7:
				System.out.println("Logging out...\n");
				return;
			default:
				System.out.println("Please input a valid choice");
			}
		}
	}

}
