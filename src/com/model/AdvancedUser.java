package com.model;

import java.util.ArrayList;
import java.util.Map;

public abstract class AdvancedUser extends User {
	
	
	private int credits;
	private String specialization;
	private ArrayList<Course> course;
	private SpecializationMode mode;
	private ArrayList<Student> student;
	private Map<Course, Double> enrolments;
	private Map<Student, Map<Course, Double>> enrolments;
	
	
	public class AdvancedUser extends User (String name, String id, String password, int credits, String specialization, ArrayList<Course> course, SpecializationMode mode, ArrayList<Student> student)
	{
		super(name, id, password);
		this.credits = credits;
		this.specialization = specialization;
		this.course = course;
		this.mode = mode;
		this.student = student;
	}
	
	public int getCredits()
	{
		return credits;
	}
	
	public String getSpecialization()
	{
		return specialization;
	}
	
	public ArrayList<Course> getCourse()
	{
		return course;
	}
	
	public ArrayList<Student> getStudent()
	{
		return student;
	}
	
	public void setCreditPointsNeeded(Program program, int credits){
	
		Program program = new Program();
		this.credits = credits;
	}
	
	public void setCoreCourses(Program program, ArrayList<Course> course)
	{
		
		Program program = new Program();
		this.course = course;
		
	}
	
	public void setSpecializationCourses(Program program, ArrayList<Course> courses, String specialization, SpecializationMode mode)
	{
		Program program = new Program();
		this.course = course;
		this.specialization = specialization;
		this.mode = mode;
	}
	
	public void setSpecializationCourses(Program program, ArrayList<Course> courses, String specialization)
	{
		Program program = new Program();
		this.courses = courses;
		this.specialization = specialization;
	}
	
	public void createStudentAccount(Student student)
	{
		Student student = new Student();
	}
	
	public void createStudentAccount(ArrayList<Student> student)
	{
		this.student = student;
	}
	
	public void uploadEnrolment(Student student, Map<Course, Double> enrolments)
	{
		Student student = new Student();
		
		Map<Course, Double> enrolments = new HashMap<Course, Double>();
		Course course = new Course(); 
		enrolments.put(course, (double) 0);
	}
	
	public void uploadEnrolment(Map<Student, Map<Course, Double>> enrolments)
	{
		Map<Course,Double> courses = new HashMap<Course,Double>();
		Map<Student, Map<Course,Double>> enrolments = new HashMap<Student, Map<Course,Double>>();
		
		Course course = new Course();
		Student student = new Student();
		
		courses.put(course,(double) 0);
		enrolments.put(student, courses);
	}

}
