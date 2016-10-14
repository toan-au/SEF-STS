package com.model.users;

import com.Global;
import com.model.Storage;
import com.model.program.Program;
import com.model.program.ProgramType;
import com.model.program.SpecializationMode;

@SuppressWarnings("serial")
public class SysAdmin extends AdvancedUser {

	public SysAdmin(String id, String name, String password) {
		super(id, name, password);
	}

	public static void createAccount() {
		System.out.println("Create a new User Account:\n" + "Please add an Id:");
		String userId = Global.scanner.next();
		System.out.println("Please add a password:");
		String password = Global.scanner.next();
		System.out.println("Please add the user's name:");
		Global.scanner.nextLine();
		String fullName = Global.scanner.nextLine();

		if (userId.startsWith("a")) {
			Storage.users.add(new SysAdmin(userId, fullName, password));
		} else if (userId.startsWith("c")) {
			Storage.users.add(new Coordinator(userId, fullName, password));
		} else if (userId.startsWith("f")) {
			Storage.users.add(new FacAdmin(userId, fullName, password));
		} else if (userId.startsWith("s")) {
			createStudentAccount(userId, fullName, password);
		} else {
			System.out.println("The account name you have entered is not valid");
			return;
		}
		if (!userId.startsWith("s"))
			System.out.println("You have just created an account with the user name " + userId + "and password " + password + ".\n"
					+ "This account is now ready to be used...");
	}

	public static void setUpNewProgram() {
		System.out.println("Enter the Program's Code");
		String inputProgramCode = Global.scanner.next();

		System.out.println("Enter the Program's Name");
		String inputProgramName = Global.scanner.next();

		System.out.println("Enter the Version Number");
		int inputVersionNumber = Global.scanner.nextInt();

		System.out.println("Enter the Program's Credit");
		int inputRequiredCredits = Global.scanner.nextInt();

		System.out.println("Is the program active? true/false");
		boolean inputIsActive = Global.scanner.nextBoolean();

		ProgramType inputProgramType = null;
		while (inputProgramType == null) {
			System.out.println("Enter the Program's type");
			String tempProgramType = Global.scanner.next().toUpperCase();

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

		SpecializationMode inputSpecializationMode = null;
		while (inputSpecializationMode == null) {
			System.out.println("Enter the Specialization Mode");
			String input = Global.scanner.next().toUpperCase();
			if (input.equals("COURSEPOOL"))
				inputSpecializationMode = SpecializationMode.COURSEPOOL;
			else if (input.equals("FIXEDSET"))
				inputSpecializationMode = SpecializationMode.FIXEDSET;
			else
				System.out.println("This type is not exist!!");
		}

		Program newProgram = new Program(inputProgramCode, inputProgramName, inputVersionNumber, inputRequiredCredits, inputIsActive,
				inputProgramType, inputSpecializationMode);

		setCoreCourses(newProgram);
		setSpecializationSetsAndCourses(newProgram);
	
		System.out.println("Program " + newProgram.getProgramCode() + " " + newProgram.getProgramName() + " has been created and added to the database");
	}
}
