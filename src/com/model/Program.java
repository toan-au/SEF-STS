package com.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Program {
	private String programCode;
	private int versionNumber;
	private int requiredCredits;
	private boolean isActive;
	private ProgramType programType;
	private ArrayList<Course> coreCourses;
	private SpecializationMode specializationMode;
	private Map<String, ArrayList<Course>> specializations;
	Scanner input = new Scanner(System.in);

	public Program(String programCode, int versionNumber, int requiredCredits, boolean isActive, ProgramType programType,
			ArrayList<Course> coreCourses, SpecializationMode specializationMode, Map<String, ArrayList<Course>> specializations) {
		this.programCode = programCode;
		this.versionNumber = versionNumber;
		this.requiredCredits = requiredCredits;
		this.isActive = isActive;
		this.programType = programType;
		this.coreCourses = coreCourses;
		this.specializationMode = specializationMode;
		this.specializations = specializations;
	}
	
	public void createProgram(){
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

	public String getProgramCode() {
		return programCode;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public int getRequiredCredits() {
		return requiredCredits;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public ProgramType getProgramType() {
		return programType;
	}

	public ArrayList<Course> getCoreCourses() {
		return coreCourses;
	}

	public SpecializationMode getSpecializationMode() {
		return specializationMode;
	}

	public Map<String, ArrayList<Course>> getSpecializations() {
		return specializations;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public void setRequiredCredits(int requiredCredits) {
		this.requiredCredits = requiredCredits;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setProgramType(ProgramType programType) {
		this.programType = programType;
	}

	public void setCoreCourses(ArrayList<Course> coreCourses) {
		this.coreCourses = coreCourses;
	}

	public void setSpecializationMode(SpecializationMode specializationMode) {
		this.specializationMode = specializationMode;
	}

	public void setSpecializations(Map<String, ArrayList<Course>> specializations) {
		this.specializations = specializations;
	}

}
