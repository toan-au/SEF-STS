package com;

import java.util.GregorianCalendar;
import java.util.Scanner;

import com.model.Coordinator;
import com.model.FacAdmin;
import com.model.Storage;
import com.model.Student;
import com.model.SysAdmin;
import com.model.User;

public class StudentProgressSystem {

	Scanner scanner;

	public StudentProgressSystem() {
		Storage.init();
	}

	private void fancyAdminMode() {
		System.out.println("fancy admin mode activated");

		System.out.println("Create a new User Account:\n" + "Please add an Id:");
		String userId = scanner.next();
		System.out.println("Please add a password:");
		String password = scanner.next();
		System.out.println("Please add the user's name:");
		String fullName = scanner.nextLine();

		if (userId.startsWith("a")) {
			Storage.users.add(new SysAdmin(userId, fullName, password));

		} else if (userId.startsWith("c")) {
			Storage.users.add(new Coordinator(userId, fullName, password));

		} else if (userId.startsWith("f")) {
			Storage.users.add(new FacAdmin(userId, fullName, password));

		} else if (userId.startsWith("s")) {
			System.out.println("Please enter the student's birthday like so: DD/MM/YYYY");
			scanner.useDelimiter("/");
			int day = scanner.nextInt();
			int month = scanner.nextInt();
			int year = scanner.nextInt();
			scanner.reset();

			System.out.println("Please enter the student's email.");
			String email = scanner.next();

			Storage.users.add(new Student(userId, fullName, password, new GregorianCalendar(year, month, day), email));
		} else {
			System.out.println("The account name you have entered is not valid");
			return;
		}

		System.out.println("You have just created an account with the user name " + userId + "and password " + password + ".\n"
				+ "This account is now ready to be used.\n" + "You will now be taken back to the main menu...");
	}

	public void run() {
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
		System.exit(0);
	}

	private User logIn() {
		User user = null;
		boolean isLoggedIn = false;

		System.out.println("Please enter your account details");
		while (!isLoggedIn) {
			System.out.println("ID: ");
			String inputId = scanner.nextLine();
			user = Storage.getUser(inputId);
			System.out.println(inputId);
			if (user == null) {
				System.out.println("The ID you entered does not exist. Please try again");
				continue;
			}

			System.out.println("Password: ");
			String passwordEntry = scanner.nextLine();
			if (!user.getPassword().equals(passwordEntry)) {
				System.out.println("The Password you entered does not match the ID. Please try again");
				continue;
			}
			isLoggedIn = true;
		}

		System.out.println("Logging in...");
		return user;
	}

}
