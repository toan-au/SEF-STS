package com.model.program;

import java.io.Serializable;
import java.util.ArrayList;
import com.model.Course;
import com.model.Storage;

@SuppressWarnings("serial")
public class Program implements Serializable {
	private String code;
	private String name;
	private int versionNumber;
	private int requiredCredits;
	private boolean isActive;
	private ProgramType type;
	private ArrayList<Course> coreCourses;
	private SpecializationMode mode;
	private SpecializationSets specializations;

	public Program(String code, String name, int versionNumber, int requiredCredits, boolean isActive, ProgramType type, SpecializationMode mode) {
		this.code = code;
		this.name = name;
		this.versionNumber = versionNumber;
		this.requiredCredits = requiredCredits;
		this.isActive = isActive;
		this.type = type;
		this.mode = mode;
		specializations = new SpecializationSets(mode);

		Storage.programs.add(this);
	}

	public Program(String code, String name, int versionNumber, int requiredCredits, boolean isActive, ArrayList<Course> coreCourses,
			ProgramType type, SpecializationMode mode) {
		this(code, name, versionNumber, requiredCredits, isActive, type, mode);
		this.coreCourses = coreCourses;
	}

	public String getProgramCode() {
		return code;
	}

	public String getProgramName() {
		return name;
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
		return type;
	}

	public ArrayList<Course> getCoreCourses() {
		return coreCourses;
	}

	public SpecializationMode getSpecializationMode() {
		return mode;
	}

	public SpecializationSets getSpecializations() {
		return specializations;
	}

	public void setProgramCode(String programCode) {
		this.code = programCode;
	}

	public void setProgramName(String programName) {
		this.name = programName;
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
		this.type = programType;
	}

	public void setCoreCourse(String courseId) {
		Course newCoreCourse = Storage.getCourse(courseId);
		coreCourses.add(newCoreCourse);
	}

	public void setSpecializationMode(SpecializationMode specializationMode) {
		this.mode = specializationMode;
	}

	public void setSpecializations(String setName, String courseId) {
		if (specializations.getSet(setName) == null) {
			specializations.addSet(setName);
		}
		specializations.addCourse(setName, courseId);
	}

	@Override
	public String toString() {
		return code + " " + name + " " + requiredCredits + " " + mode;
	}

}
