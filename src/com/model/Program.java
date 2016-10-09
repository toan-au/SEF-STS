package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Program implements Serializable {
	private String programCode;
	private int versionNumber;
	private int requiredCredits;
	private boolean isActive;
	private ProgramType programType;
	private ArrayList<Course> coreCourses;
	private SpecializationMode specializationMode;
	private Specializations specializations;
	Scanner input = new Scanner(System.in);

	public Program(String programCode, int versionNumber, int requiredCredits, boolean isActive, ProgramType programType) {
		this.programCode = programCode;
		this.versionNumber = versionNumber;
		this.requiredCredits = requiredCredits;
		this.isActive = isActive;
		this.programType = programType;
		// this.coreCourses = coreCourses;
		this.specializationMode = specializationMode;
		if (specializationMode == SpecializationMode.COURSEPOOL)
			specializations = new CoursePool();
		else
			specializations = new FixedSet();
		
		Storage.programs.add(this);
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

	// TODO: IMPLEMENT THIS METHOD
	public Collections getSpecializations() {
		if(specializationMode == SpecializationMode.COURSEPOOL){
			return specializations.getCourses();
		}
		else
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

	// TODO IMPLEMENT THIS FUCNTION
	public void setSpecializations() {
	}

	/*
	 * spec mode:
	 * if it's just a course pool:
	 * course pool of all possible courses
	 * if it's an actual mode:
	 * ArrayList<SpecializationPipes>
	 * SpecPipe: Map<String pipeName, ArrayList <Courses>>
	 */

	@Override
	public String toString() {
		return programCode + " " + requiredCredits + " " + specializationMode;
	}

}
