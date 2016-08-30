package com.model;

import java.util.Date;
import java.util.Map;

public class Student extends User{

	private String studentID;
	private String surname;
	private String givenNames;
	private Date dateOfBirth;
	private String emailAddress;
	private Map<Course, Double> courses;
}
