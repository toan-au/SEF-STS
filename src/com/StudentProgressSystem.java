package com;

import java.util.Scanner;

import com.model.Storage;
import com.model.SysAdmin;
import com.model.User;

public class StudentProgressSystem {

	User currentUser;
	Scanner logInScanner;

	public StudentProgressSystem() {
		logInScanner = new Scanner(System.in);
		
	}

	private void fancyAdminMode() {
		SysAdmin fancyAdmin = new SysAdmin("temp", "temp", "temp");
		System.out.println("fancy admin mode activated");
		// TODO Auto-generated method stub

	}

	public void run() {
		System.out.println("Welcome to this thing. Press Enter to begin.");
		if (logInScanner.nextLine().equals("UpUpDownDownLeftRightLeftRightBA"))
			fancyAdminMode();
		
		validate();
		
		Class userClass = currentUser.getClass();
		switch userClass:
		case Student:
			displayStudentMenu();
			displayFacAdminMenu();
			displaySysadminMenu();
			displayCoordinatorMenu();
			
		logInScanner.close();
	}

	private void displayCoordinatorMenu() {
		// TODO Auto-generated method stub
		
	}

	private void displaySysadminMenu() {
		// TODO Auto-generated method stub
		
	}

	private void displayFacAdminMenu() {
		// TODO Auto-generated method stub
		
	}

	private void displayStudentMenu() {
		// TODO Auto-generated method stub
		
	}

	private void validate() {
		boolean isLoggedIn = false;
		User tempUser;

		System.out.println("Please enter your account details");
		while (!isLoggedIn) {
			System.out.println("User Name: ");
			tempUser = Storage.getUser(logInScanner.nextLine());
			if (tempUser == null) {
				System.out.println("The User Name you entered does not exist. Please try again");
				continue;
			}

			System.out.println("Pasword: ");
			String passwordEntry = logInScanner.nextLine();
			if (!tempUser.getPassword().equals(passwordEntry)) {
				System.out.println("The Password you entered does not match the user name. Please try again");
				continue;
			}

			currentUser = tempUser;
			System.out.println("Logging in...");
			isLoggedIn = true;
		}
	}

}
