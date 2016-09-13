package com.model;

import java.util.ArrayList;
import java.util.Map;

public class SysAdmin extends AdvancedUser {

	public SysAdmin(String id, String name, String password) {
		super(id, name, password);
	}

	public void createAccount() {
	
	}

	public void setUpNewProgram() {
		String inputProgramCode;
		int inputVersionNumber;
		int inputRequiredCredits;
		boolean inputIsActive;
		ProgramType inputProgramType;
		String tempProgramType;
		ArrayList<Course> inputCoreCourses;
		String tempCoreCourse;
		SpecializationMode inputSpecializationMode;
		String tempSpMode;
		Map<String, ArrayList<Course>> inputSpecializations;
		
		System.out.println("Enter the Program's Code");
		inputProgramCode = input.next();

		System.out.println("Enter the Version Number");
		inputVersionNumber = input.nextInt();
		
		System.out.println("Enter the Program's Credit");
		inputRequiredCredits = input.nextInt();
		
		System.out.println("Is the program active? true/false");
		inputIsActive = input.nextBoolean();
		
		System.out.println("Enter the Program's type");
		tempProgramType = input.next();
		//change input to upper case
		tempProgramType = tempProgramType.toUpperCase();
		if (tempProgramType.equals("BACHELOR")){
			inputProgramType = ProgramType.BACHELOR;
		}else if (tempProgramType.equals("HONOURS")){
			inputProgramType = ProgramType.HONOURS;
		}else if (tempProgramType.equals("GRADDIPLOMA")){
			inputProgramType = ProgramType.GRADDIPLOMA;
		}else if (tempProgramType.equals("MASTERS")){
			inputProgramType = ProgramType.MASTERS;
		}else{
			inputProgramType = ProgramType.BACHELOR;
			System.out.println("This type is not exist!!");
		}
		
//		System.out.println("Enter the Core Course");
//		tempProgramType = input.next();
//		if (tempProgramType.equals("CoreCourse1")){
//			inputCoreCourses = Storage.courses[0];
//		}else if (tempProgramType.equals("CoreCourse2")){
//			inputCoreCourses = Storage.courses[1];
//		}else if (tempProgramType.equals("CoreCourse3")){
//			inputCoreCourses = Storage.courses[2];
//		}else{
//			System.out.println("This course is not exist!!");
//		}
//		
//		System.out.println("Enter the Specialization Mode");
//		tempSpMode = input.next();
//		//change input to upper case
//		tempSpMode = tempSpMode.toUpperCase();
//		
//		if (tempSpMode.equals("FIXEDSET")){
//			inputSpecializationMode = SpecializationMode.FIXEDSET;
//		}else if (tempSpMode.equals("COURSEPOOL")){
//			inputSpecializationMode = SpecializationMode.COURSEPOOL;
//		}else{
//			System.out.println("This Mode is not exist!!");
//		}
//		
//		System.out.println("Enter the Specialization");
//		inputSpecializations = input.next();
		
		Program newProgram = new Program(inputProgramCode, inputVersionNumber, inputRequiredCredits, inputIsActive, inputProgramType);
		
		//Store the new course to the array.
		Storage.programs.add(newProgram);
		
		//inform user that the program has been created
		System.out.println("Program " + newProgram.getProgramCode() + " has been created and added to the database");
	}
}
