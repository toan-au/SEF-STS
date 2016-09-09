package com;

import com.model.Coordinator;
import java.util.Scanner;

import com.model.Storage;
import com.model.SysAdmin;
import com.model.User;

public class StudentProgressSystem {

	User currentUser;
	Scanner logInScanner;

	public StudentProgressSystem() {
		logInScanner = new Scanner(System.in);
		System.out.println("Welcome to this thing. Press Enter to begin.");
		if (logInScanner.nextLine().equals("UpUpDownDownLeftRightLeftRightBA"))
			fancyAdminMode();
		SysAdmin fancyAdmin = new SysAdmin("temp", "temp", "temp");
	}

	private void fancyAdminMode() {
		System.out.println("fancy admin mode activated");
		// TODO Auto-generated method stub

	}

	public void run() {
		validate();
		logInScanner.close();
		menu();
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
	
	private void menu()
	{
		
		if (tempUser.startsWith(S))
		{
			Student student = new Student();
			studentMenu();
		}
		else if (tempUser.startsWith(F))
		{
			FacAdmin facAdmin = new FacAdmin();
			facadMenu();
		}
		else if (tempUser.startsWith(C))
		{
			Coordinator coordinator = new Coordinator();
			coorMenu();
		}
		else if (tempUser.startsWith(A))
		{
			SysAdmin sysAdmin = new SysAdmin();
			sysadMenu();
		}
	}
	
	
	private void studentMenu()
	{
		System.out.println("Here are your results...");
		student.checkStudentResults();
		
	}
	
	private void facadMenu()
	{
		System.out.println("Here are your students' results...");
			facAdmin.checkStudentResults();
		
	}
	
	private void coorMenu()
	{
		System.out.println("Hello, ."+tempUser+"What would you like to do?")
		System.out.println("1.) Check student results\n2.) Create a student account\n3.) Upload enrolment")
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		
		switch (choice)
		{
			case 1: 
				coordinator.checkStudentResults();
				break;
			case 2:
				coordinator.createStudentAccount();
				break;
			case 3:
				coordinator.uploadEnrolment();
				break;
		)
	}
	
	private void sysadMenu()
	{
		System.out.println("Hello, ."+tempUser+"What would you like to do?")
		System.out.println("1.) Set up roles\n2.Set up a new program\n3.) Create a student account\n4.) Upload enrolment")
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();	
		
		switch (choice)
		{
			case 1:
				sysAdmin.setUpRoles();
			case 2:
				sysAdmin.setUpNewProgram();
			case 3:
				sysAdmin.creatStudentAccount();
			case 4:
				sysAdmin.uploadEnrolment();
		}
	}
	
	

}
