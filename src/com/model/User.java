package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.Starter;
import com.controller.Storage;
import com.view.StudentProgressSystem;

@SuppressWarnings("serial")
public class User implements Serializable {
	protected String name;
	protected String id;
	protected String password;
	private Role role;

	public User(String id, String name, String password, Role role) {
		this.name = name;
		this.password = password;
		this.role = role;
		setId();
		Storage.users.add(this);
	}

	private void setId() {
		Starter.currentIDPosition++;
		String roleString = null;

		if (role == Role.COORDINATOR)
			roleString = "c";
		else if (role == Role.FACADMIN)
			roleString = "f";
		else if (role == Role.STUDENT)
			roleString = "s";
		else if (role == Role.SYSADMIN)
			roleString = "a";

		this.id = roleString + String.format("%07d", Starter.currentIDPosition);
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public Role getRole() {
		return role;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
	protected void createStudentAccount(String userId, String password, String fullName) {
		System.out.println("Please enter the student's birthday like so: DD/MM/YYYY");
		StudentProgressSystem.scanner.useDelimiter("/");
		int day = StudentProgressSystem.scanner.nextInt();
		int month = StudentProgressSystem.scanner.nextInt();
		int year = StudentProgressSystem.scanner.nextInt();
		StudentProgressSystem.scanner.reset();

		System.out.println("Please enter the student's email.");
		String email = StudentProgressSystem.scanner.next();

		@SuppressWarnings("unused")
		Student student = new Student(userId, fullName, password, new GregorianCalendar(year, month, day), email);

		System.out.println("You have just created an account with the user name " + userId + "and password " + password + ".\n"
				+ "This account is now ready to be used.");
	}

	public void createStudentAccount(ArrayList<Student> student) {

	}


	public void createAccount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Create a new User Account:\n" + "Please add an Id:");
		String userId = scanner.next();
		System.out.println("Please add a password:");
		String password = scanner.next();
		System.out.println("Please add the user's name:");
		String fullName = scanner.nextLine();

		if (userId.startsWith("a")) {
			Storage.users.add(new User(userId, fullName, password, Role.SYSADMIN));

		} else if (userId.startsWith("c")) {
			Storage.users.add(new User(userId, fullName, password, Role.COORDINATOR));

		} else if (userId.startsWith("f")) {
			Storage.users.add(new User(userId, fullName, password, Role.FACADMIN));

		} else if (userId.startsWith("s")) {
			createStudentAccount(userId, password, fullName);
		} else {
			System.out.println("The account name you have entered is not valid");
			scanner.close();
			return;
		}
		if (!userId.startsWith("s"))
			System.out.println("You have just created an account with the user name " + userId + "and password " + password + ".\n"
					+ "This account is now ready to be used..");
		scanner.close();
	}

	public String toString() {
		return "\n" + id + " " + name;

	}

}
