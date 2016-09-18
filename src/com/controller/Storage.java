package com.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.model.Course;
import com.model.Program;
import com.model.User;

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

	public static void printAllUsers() {
		for (User user : users)
			System.out.print(user);
	}

	public static void printAllCourses() {
		for (Course course : courses)
			System.out.print(course);
	}

	public static void printAllPrograms() {
		for (Program program : programs)
			System.out.print(program);
	}

	@SuppressWarnings("unchecked")
	public static void fetchStoredData() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ISL_filepath.dat"));
			users = (ArrayList<User>) ois.readObject();
			System.out.println("Users loaded");
			courses = (ArrayList<Course>) ois.readObject();
			System.out.println("Courses loaded");
			programs = (ArrayList<Program>) ois.readObject();
			System.out.println("Programs loaded");
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Could not fetch saved data.");
			e.printStackTrace();
		}
	}

	public static void saveStoredData() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ISL_filepath.dat"));
			oos.writeObject(users);
			System.out.println("Users saved");
			oos.writeObject(courses);
			System.out.println("Courses saved");
			oos.writeObject(programs);
			System.out.println("Programs saved");
			oos.close();
		} catch (IOException e) {
			System.out.println("Could not save data	.");
			e.printStackTrace();
		}
	}
}
