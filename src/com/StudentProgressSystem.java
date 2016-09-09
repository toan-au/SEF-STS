package com;

import java.util.Scanner;

import com.model.Storage;
import com.model.User;

public class StudentProgressSystem {

	User currentUser;

	public StudentProgressSystem() {
		validate();

	}

	public void run() {

	}

	private void validate() {
		Scanner scanner = new Scanner(System.in);
		boolean isLoggedIn = false;
		User tempUser;
		
		System.out.println("Please enter your account details");
		while (!isLoggedIn) {
			System.out.println("User Name: ");
			tempUser = Storage.getUser(scanner.next());
			if (tempUser == null) {
				System.out.println("The User Name you entered does not exist. Please try again");
				continue;
			}

			System.out.println("Pasword: ");
			String passwordEntry = scanner.next();
			if (tempUser.getPassword() != passwordEntry) {
				System.out.println("The Password you entered does not match the user name. Please try again");
				continue;
			}

			currentUser = tempUser;
			System.out.println("Logging in...");
			isLoggedIn = true;
		}
		scanner.close();
	}

}
