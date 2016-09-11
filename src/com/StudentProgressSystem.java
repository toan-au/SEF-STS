package com;

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

	public StudentProgressSystem() {
		scanner = new Scanner(System.in);
	}

	private void fancyAdminMode() {
		@SuppressWarnings("unused")
		SysAdmin fancyAdmin = new SysAdmin("temp", "temp", "temp");
		System.out.println("fancy admin mode activated");

		System.out.println("Create a new User Account:\n" + "Please add an Id:");
		String userId = scanner.next();
		System.out.println("Please add a password:");
		String password = scanner.next();
		
		if (userId.startsWith("S")) {
			System.out.println("You have just created a student account.");
			System.out.println("You will now be taken back to the menu...");
			run();
		} else if (userId.startsWith("F")) {
			System.out.println("You have just created a faculty admin account.");
			System.out.println("You will now be taken back to the menu...");
			run();
		} else if (userId.startsWith("C")) {
			System.out.println("You have just created a coordinator account.");
			System.out.println("You will now be taken back to the menu...");
			run();
		} else if (userId.startsWith("A")) {
			System.out.println("You have just created a system admin account.");
			System.out.println("You will now be taken back to the menu...");
			run();
		}
		

	}

	public void run() {
		Storage.init();
		System.out.println("Welcome to this thing. Press Enter to begin.");
		if (scanner.nextLine().equals("UpUpDownDownLeftRightLeftRightBA"))
			fancyAdminMode();

		validate();
		menu();
		scanner.close();
	}

	private void validate() {
		boolean isLoggedIn = false;
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

			System.out.println("Pasword: ");
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

	private void menu() {
		String userId = currentUser.getId();

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
		System.out.println("Hello, ." + currentUser.getId() + "What would you like to do?");
		System.out.println("1 - Check your results\n");
		System.out.println("2 - log out\n");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		
		//set a flag for continue run the loop until log out.
		boolean studentFlag = true;
		while (studentFlag){
			switch (choice) {
			case 1:
				System.out.println("Here are your results...");
				currentUser.checkStudentResults((Student) currentUser);
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
		System.out.println("Hello, ." + currentUser.getId() + "What would you like to do?");
		//System.out.println("1.) Check student results\n" + "2.) Create a student account\n" + "3.) Upload enrolment");
		System.out.println("1 - Check student results\n");
		System.out.println("2 - Create a student account\n");
		System.out.println("3 - Upload enrolment\n");
		System.out.println("4 - log out\n");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();

		//set a flag for continue run the loop until log out.
		boolean coordinatorFlag = true;
		while (coordinatorFlag){
			switch (choice) {
			case 1:
				// currentUser.checkStudentResults();
				break;
			case 2:
				((Coordinator)currentUser).createStudentAccount();
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
		//boolean to determine if we should loop
		boolean loop = true;
		
		while(loop) {
			System.out.println("Hello, ." + currentUser.getId() + "\nWhat would you like to do?\n");
			System.out.println("1 - Set up roles");
			System.out.println("2 - Set up a new program");
			System.out.println("3 - Create a student account");
			System.out.println("4 - Upload enrolment");
			System.out.println("5 - log out");
			
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				//currentUser.setUpRoles();
				break;
			case 2:
				((SysAdmin)currentUser).setUpNewProgram();
				break;
			case 3:
				((SysAdmin)currentUser).createStudentAccount();
				break;
			case 4:
				//currentUser.uploadEnrolment();
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
