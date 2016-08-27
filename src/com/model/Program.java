package com.model;

import java.util.ArrayList;
import java.util.Map;

public class Program {
	private String programCode;
	private int versionNumber;
	private int requiredCredits;
	private boolean isActive;
	private ProgramType programType;
	private ArrayList<Course> coreCourses;
	private SpecializationMode specializationMode;
	private Map<String, ArrayList<Course>> specializations;
}
