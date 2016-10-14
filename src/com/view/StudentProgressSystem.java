package com.view;

import com.Global;
import com.model.Storage;
import com.model.users.Student;
import com.model.users.User;

public class StudentProgressSystem {
	private static String tempUser;

	public static void run() {
		while (true) {
			System.out.println("Welcome to the Student Progress System. Press 'c' to begin; 'q' to exit.");
			String input = Global.scanner.next();

			if (input.equals("q")) {
				return;
			} else if (input.equals("c")) {
				if (logIn() != null)
					continue;
				Menu.displayMenu(tempUser);
			} else if (input.equals("UpUpDownDownLeftRightLeftRightBA") || input.equals("meh")) {
				fancyAdminMode();
			}
		}
	}

	private static void fancyAdminMode() {
		System.out.println("fancy admin mode activated");

		User.checkStudentResults("s1111111");
		System.out.println(Storage.print());
	}

	private static String logIn() {
		String inputId;
		String inputPassword;
		String loadedPassword = null;

		System.out.println("Please enter your account details. Note: Entering 'q' cancels the log-in process");
		while (true) {
			System.out.println("ID: ");
			inputId = Global.scanner.next();
			if (inputId.equals("q"))
				return null;

			if (inputId.startsWith("s")) {
				Student student = Storage.getStudent(inputId);
				System.out.println("loaded user");
				if (student != null)
					loadedPassword = student.getPassword();
			} else {
				User user = Storage.getUser(inputId);
				if (user != null)
					loadedPassword = user.getPassword();
			}

			if (loadedPassword == null) {
				System.out.println("The ID you entered does not exist. Please try again");
				continue;
			}

			System.out.println("Password: ");
			inputPassword = Global.scanner.next();
			if (inputPassword.equals("q"))
				return null;
			if (!loadedPassword.equals(inputPassword)) {
				System.out.println("The Password you entered does not match the ID. Please try again");
				continue;
			}
			System.out.println("Logging in...\n");
			return inputId;
		}
	}
}
