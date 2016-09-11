package com.model;

import java.util.ArrayList;
import java.util.Map;

public class SysAdmin extends AdvancedUser {

	public SysAdmin(String id, String name, String password) {
		super(id, name, password);
	}

	public void setUpRoles(User user) {
	
	}

	public void setUpNewProgram(Program program) {
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
		
		System.out.println("Enter the Program's status, active or inactive");
		inputIsActive = input.nextBoolean();
		
		System.out.println("Enter the Program's type");
		tempProgramType = input.next();
		//change input to upper case
		tempProgramType = tempProgramType.toUpperCase();
		if (tempProgramType.equals("BACHELOR")){
			inputProgramType = enum BACHELOR;
		}else if (tempProgramType.equals("HONOURS")){
			inputProgramType = enum HONOURS;
		}else if (tempProgramType.equals("GRADDIPLOMA")){
			inputProgramType = enum GRADDIPLOMA;
		}else if (tempProgramType.equals("MASTERS")){
			inputProgramType = enum MASTERS;
		}else{
			System.out.println("This type is not exist!!");
		}
		
		System.out.println("Enter the Core Course");
		tempProgramType = input.next();
		if (tempProgramType.equals("CoreCourse1")){
			inputCoreCourses = Storage.courses[0];
		}else if (tempProgramType.equals("CoreCourse2")){
			inputCoreCourses = Storage.courses[1];
		}else if (tempProgramType.equals("CoreCourse3")){
			inputCoreCourses = Storage.courses[2];
		}else{
			System.out.println("This course is not exist!!");
		}
		
		System.out.println("Enter the Specialization Mode");
		tempSpMode = input.next();
		//change input to upper case
		tempSpMode = tempSpMode.toUpperCase();
		
		if (tempSpMode.equals("FIXEDSET")){
			inputSpecializationMode = enum FIXEDSET;
		}else if (tempSpMode.equals("COURSEPOOL")){
			inputSpecializationMode = enum COURSEPOOL;
		}else{
			System.out.println("This Mode is not exist!!");
		}
		
		System.out.println("Enter the Specialization");
		inputSpecializations = input.next();
		
		Course newCourse = new Course(inputProgramCode, inputVersionNumber, inputRequiredCredits, inputIsActive, inputProgramType, inputCoreCourses, inputSpecializationMode, inputSpecializations);
		
		//Store the new course to the array.
		Storage.course.add(newCourse);
	}
}
