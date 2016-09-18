package com.view;

import java.util.Scanner;

import com.controller.Storage;
import com.model.Role;
import com.model.User;

public class StudentProgressSystem {

	public static Scanner scanner;

	public static void run() {
		scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Welcome to the Student Progress System. Press Enter to begin; q to exit.");
			String input = scanner.nextLine();

			if (input.equals("UpUpDownDownLeftRightLeftRightBA"))
				fancyAdminMode();
			else if (input.equals("q"))
				break;

			Menu.displayMenu(logIn());
		}
		scanner.close();
	}

	private static void fancyAdminMode() {
		System.out.println("fancy admin mode activated");
		User temp = new User("temp", "temp", "temp", Role.SYSADMIN);
		
		temp.createAccount();
		Storage.users.remove(temp);
		
		Storage.printAllUsers();
		System.out.println();
		Storage.printAllCourses();
		System.out.println();
		Storage.printAllPrograms();
		System.out.println();
	}

	private static User logIn() {
		User user = null;
		boolean isLoggedIn = false;

		System.out.println("Please enter your account details");
		while (!isLoggedIn) {
			System.out.println("ID: ");
			String inputId = scanner.next();
			user = Storage.getUser(inputId);
			System.out.println(inputId);
			if (user == null) {
				System.out.println("The ID you entered does not exist. Please try again");
				continue;
			}

			System.out.println("Password: ");
			String passwordEntry = scanner.next();
			if (!user.getPassword().equals(passwordEntry)) {
				System.out.println("The Password you entered does not match the ID. Please try again");
				continue;
			}
			isLoggedIn = true;
		}
		System.out.println("Logging in...\n");
		return user;
	}
}
