package com.model;

import java.util.ArrayList;
import java.util.Map;

public abstract class AdvancedUser{

	public void setCreditPointsNeeded(Program program, int credits){
		
	}
	
	public void setCoreCourses(Program program, ArrayList<Course> course){
		
	}
	
	public void setSpecializationCourses(Program program, ArrayList<Course> courses, String specialization, SpecializationMode mode){
		
	}
	
	public void setSpecializationCourses(Program program, ArrayList<Course> courses, String specialization){

	}
	
	public void createStudentAccount(Student student){

	}
	
	public void createStudentAccount(ArrayList<Student> student){

	}
	
	public void uploadEnrolment(Student student, Map<Course, Double> enrolments){

	}
	
	public void uploadEnrolment(Map<Student, Map<Course, Double>> enrolments){

	}

}
