package com.model;

import java.util.ArrayList;

public class Storage {
	// An arraylist of users
	public static ArrayList<User> users = new ArrayList<User>(256);
	public static ArrayList<Course> courses = new ArrayList<Course>(256);
	public static ArrayList<Program> programs = new ArrayList<Program>(256);
	
	
	// returns a User object if there is a match in IDs, return null otherwise
	public static User getUser(String id) {
		if (users.isEmpty())
			return null;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i) != null && users.get(i).getId() == id) {
				return users.get(i);			// return the user if tehre is a match
			}
		}
		return null;
	}
	
	
	// Return a course object with the same id or null
	public static Course getCourse(String id) {
		if (courses.isEmpty())
			return null;
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i) != null && courses.get(i).getCourseID() == id) {
				return courses.get(i);			// return the user if tehre is a match
			}
		}
		return null;
	}
	
	
	
}
