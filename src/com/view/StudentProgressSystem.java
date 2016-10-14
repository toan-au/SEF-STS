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
			} else if (input.equals("c") && logIn() != null) {
				Menu.displayMenu(tempUser);
			} else if (input.equals("DataPrintMode")) {
				User.checkStudentResults("s1111111");
				System.out.println(Storage.print());
			}
		}
	}

	private static String logIn() {
		String inputId;
		String inputPassword;
		String loadedPassword = null;

		System.out.println("Please enter your account details. Note: Entering 'q' cancels the log-in process");
		while (true) {
			System.out.print("ID: ");
			inputId = Global.scanner.next();
			if (inputId.equals("q"))
				return null;

			tempUser = inputId;
			if (tempUser.startsWith("s")) {
				Student student = Storage.getStudent(tempUser);
				if (student != null)
					loadedPassword = student.getPassword();
			} else {
				User user = Storage.getUser(tempUser);
				if (user != null)
					loadedPassword = user.getPassword();
			}

			if (loadedPassword == null) {
				System.out.println("The ID you entered does not exist. Please try again");
				continue;
			}

			System.out.print("Password: ");
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
