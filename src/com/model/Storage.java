package com.model;

import java.util.ArrayList;

public class Storage {
	public static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<Course> courses = new ArrayList<Course>();
	public static ArrayList<Program> programs = new ArrayList<Program>();

	public static User getUser(String id) {
		for (User user : users) {
			if (user.getId().equals(id))
				return user;
		}
		return null;
	}

	public static Course getCourse(String id) {
		for (Course course : courses) {
			if (course.getCourseId().equals(id))
				return course;
		}
		return null;
	}

	public static Program getProgram(String programCode) {
		for (Program program : programs) {
			if (program.getProgramCode().equals(programCode))
				return program;
		}
		return null;
	}

}
