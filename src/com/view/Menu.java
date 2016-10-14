package com.view;

import com.Global;
import com.model.Storage;
import com.model.users.AdvancedUser;
import com.model.users.Coordinator;
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

			switch (Global.convertInputToInteger(Global.scanner.next())) {
			case 1:
				System.out.println("Your results are:");
				User.checkStudentResults(userId);
				System.out.println("\n");
				break;
			case 2:
				System.out.println("Logging out...\n");
				return;
			default:
				System.out.println("Please input a valid choice");
			}
		}
	}

	private static void displayFacAdminMenu(String userId) {
		System.out.println("Hello, " + Storage.getUser(userId).getName() + ". Entering 'q' at any point will log you out.");
		while (true) {
			System.out.print("Please enter a student id: ");
			String input = Global.scanner.next();

			if (Storage.getUser(input) == null) {
				if (input.equals("q")) {
					System.out.println("Logging out...\n");
					return;
				}
				System.out.println("The entered student id does not exist");
				continue;
			}
			System.out.println("Here are " + Storage.getUser(input) + "'s results...");
			User.checkStudentResults(input);
		}
	}

	private static void displayCoordinatorMenu(String userId) {
		System.out.println("Hello, " + Storage.getUser(userId).getName() + ". What would you like to do?");
		while (true) {
			System.out.println("1 - Check student results");
			System.out.println("2 - Check program completion");
			System.out.println("3 - Create a student account");
			System.out.println("4 - upload student accounts");
			System.out.println("5 - create enrolment");
			System.out.println("6 - Edit Program");
			System.out.println("7 - log out");

			switch (Global.convertInputToInteger(Global.scanner.next())) {
			case 1:
				System.out.print("Please enter a student id: ");
				String input = Global.scanner.next();

				if (Storage.getUser(input) == null) {
					System.out.println("The entered student id does not exist");
					break;
				}
				System.out.println("Here are " + Storage.getUser(input) + "'s results...");
				User.checkStudentResults(input);
				break;
			case 2:
				Coordinator.checkProgramCompletion();
				break;
			case 3:
				AdvancedUser.createStudentAccount();
				break;
			case 4:
				AdvancedUser.createStudentAccounts();
				break;
			case 5:
				AdvancedUser.createEnrolment();
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

	private static void displaySysAdminMenu(String userId) {
		System.out.println("Hello, " + Storage.getUser(userId).getName() + ". What would you like to do?");

		while (true) {
			System.out.println("1 - Set up roles");
			System.out.println("2 - Set up new program");
			System.out.println("3 - Create student account");
			System.out.println("4 - Upload student accounts");
			System.out.println("5 - create Enrolment");
			System.out.println("6 - Upload Enrolments");
			System.out.println("7 - Edit a Program");
			System.out.println("8 - log out");

			switch (Global.convertInputToInteger(Global.scanner.next())) {
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
				AdvancedUser.createEnrolment();
				break;
			case 6:
				AdvancedUser.uploadEnrolments();
				break;
			case 7:
				AdvancedUser.editProgram();
				break;
			case 8:
				System.out.println("Logging out...\n");
				return;
			default:
				System.out.println("Please input a valid choice");
			}
		}
	}

}
