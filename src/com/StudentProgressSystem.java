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
	Scanner logInScanner;

	public StudentProgressSystem() {
		logInScanner = new Scanner(System.in);
	}

	private void fancyAdminMode() {
		@SuppressWarnings("unused")
		SysAdmin fancyAdmin = new SysAdmin("temp", "temp", "temp");
		System.out.println("fancy admin mode activated");

		Scanner fancyScanner = new Scanner(System.in);
		System.out.println("Create a new User Account:\n" + "Please add an Id:");
		String userId = fancyScanner.next();
		System.out.println("Please add a password:");
		String password = fancyScanner.next();
		
		if (userId.startsWith("S")) {
			System.out.println("Please enter all the other stuff, Anna, this is your job, I'm too lazy");
			String something = fancyScanner.next();
		} else if (userId.startsWith("F")) {
			System.out.println("Please enter all the other stuff, Anna, this is your job, I'm too lazy");
			String something = fancyScanner.next();
		} else if (userId.startsWith("C")) {
			System.out.println("Please enter all the other stuff, Ana, this is your job, I'm too lazy");
			String something = fancyScanner.next();
		} else if (userId.startsWith("A")) {
			System.out.println("Please enter all the other stuff, Ana, this is your job, I'm too lazy");
			String something = fancyScanner.next();
		}
	}

	public void run() {
		Storage.init();
		System.out.println("Welcome to this thing. Press Enter to begin.");
		if (logInScanner.nextLine().equals("UpUpDownDownLeftRightLeftRightBA"))
			fancyAdminMode();

		validate();
		logInScanner.close();
		menu();
	}

	private void validate() {
		boolean isLoggedIn = false;
		User tempUser;

		System.out.println("Please enter your account details");
		while (!isLoggedIn) {
			System.out.println("ID: ");
			String inputId = logInScanner.nextLine();
			tempUser = Storage.getUser(inputId);
			System.out.println(inputId);
			if (tempUser == null) {
				System.out.println("The ID you entered does not exist. Please try again");
				continue;
			}

			System.out.println("Pasword: ");
			String passwordEntry = logInScanner.nextLine();
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
		System.out.println("Here are your results...");
		currentUser.checkStudentResults((Student) currentUser);

	}

	private void displayFacAdminMenu() {
		System.out.println("Here are your students' results...");
		// currentUser.checkStudentResults();

	}

	private void displayCoordinatorMenu() {
		System.out.println("Hello, ." + currentUser.getId() + "What would you like to do?");
		System.out.println("1.) Check student results\n" + "2.) Create a student account\n" + "3.) Upload enrolment");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			// currentUser.checkStudentResults();
			break;
		case 2:
			// currentUser.createStudentAccount();
			break;
		case 3:
			// currentUser.uploadEnrolment();
			break;
		}
	}

	private void displaySysAdminMenu() {
		System.out.println("Hello, ." + currentUser.getId() + "What would you like to do?");
		System.out.println("1.) Set up roles\n" + "2.Set up a new program\n" + "3.) Create a student account\n" + "4.) Upload enrolment");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			// currentUser.setUpRoles();
		case 2:
			// currentUser.setUpNewProgram();
		case 3:
			// currentUser.creatStudentAccount();
		case 4:
			// currentUser.uploadEnrolment();
		}
	}

}
