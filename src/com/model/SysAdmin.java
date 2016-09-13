package com.model;

import java.util.Scanner;

public class SysAdmin extends AdvancedUser {

	public SysAdmin(String id, String name, String password) {
		super(id, name, password);
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
			Storage.users.add(new SysAdmin(userId, fullName, password));

		} else if (userId.startsWith("c")) {
			Storage.users.add(new Coordinator(userId, fullName, password));

		} else if (userId.startsWith("f")) {
			Storage.users.add(new FacAdmin(userId, fullName, password));

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

	public void setUpNewProgram() {
		System.out.println("Enter the Program's Code");
		String inputProgramCode = scanner.next();

		System.out.println("Enter the Version Number");
		int inputVersionNumber = scanner.nextInt();

		System.out.println("Enter the Program's Credit");
		int inputRequiredCredits = scanner.nextInt();

		System.out.println("Is the program active? true/false");
		boolean inputIsActive = scanner.nextBoolean();

		ProgramType inputProgramType = null;
		while (inputProgramType == null) {
			System.out.println("Enter the Program's type");
			String tempProgramType = scanner.next().toUpperCase();

			if (tempProgramType.equals("BACHELOR"))
				inputProgramType = ProgramType.BACHELOR;
			else if (tempProgramType.equals("HONOURS"))
				inputProgramType = ProgramType.HONOURS;
			else if (tempProgramType.equals("GRADDIPLOMA"))
				inputProgramType = ProgramType.GRADDIPLOMA;
			else if (tempProgramType.equals("MASTERS"))
				inputProgramType = ProgramType.MASTERS;
			else
				System.out.println("This type is not exist!!");
		}
		// System.out.println("Enter the Core Course");
		// tempProgramType = input.next();
		// if (tempProgramType.equals("CoreCourse1")){
		// inputCoreCourses = Storage.courses[0];
		// }else if (tempProgramType.equals("CoreCourse2")){
		// inputCoreCourses = Storage.courses[1];
		// }else if (tempProgramType.equals("CoreCourse3")){
		// inputCoreCourses = Storage.courses[2];
		// }else{
		// System.out.println("This course is not exist!!");
		// }
		//
		// System.out.println("Enter the Specialization Mode");
		// tempSpMode = input.next();
		// //change input to upper case
		// tempSpMode = tempSpMode.toUpperCase();
		//
		// if (tempSpMode.equals("FIXEDSET")){
		// inputSpecializationMode = SpecializationMode.FIXEDSET;
		// }else if (tempSpMode.equals("COURSEPOOL")){
		// inputSpecializationMode = SpecializationMode.COURSEPOOL;
		// }else{
		// System.out.println("This Mode is not exist!!");
		// }
		//
		// System.out.println("Enter the Specialization");
		// inputSpecializations = input.next();

		Program newProgram = new Program(inputProgramCode, inputVersionNumber, inputRequiredCredits, inputIsActive, inputProgramType);

		// Store the new course to the array.
		Storage.programs.add(newProgram);

		// inform user that the program has been created
		System.out.println("Program " + newProgram.getProgramCode() + " has been created and added to the database");
	}
}
