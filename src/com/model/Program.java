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

	public Program(String programCode, int versionNumber, int requiredCredits, boolean isActive, ProgramType programType) {
		this.programCode = programCode;
		this.versionNumber = versionNumber;
		this.requiredCredits = requiredCredits;
		this.isActive = isActive;
		this.programType = programType;
//		this.coreCourses = coreCourses;
//		this.specializationMode = specializationMode;
//		this.specializations = specializations;
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
