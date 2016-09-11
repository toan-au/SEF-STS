package com.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Storage {
	public static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<Course> courses = new ArrayList<Course>();
	public static ArrayList<Program> programs = new ArrayList<Program>();
	
	// add a student
	private static Student student1 = new Student("s1111111", "Toan Au", "password", new GregorianCalendar(1993, 12, 25), "toan@email.com");
	private static Student student2 = new Student("s2222222", "Bob Builder", "password", new GregorianCalendar(1990, 1, 1), "bob@email.com");
	private static Student student3 = new Student("s3333333", "Harold Senpai", "password", new GregorianCalendar(1999, 6, 13), "harold@email.com");
	private static Student student4 = new Student("s4444444", "Sophie Au", "password", new GregorianCalendar(1800, 5, 25), "sophie@email.com");
	private static Student student5 = new Student("s5555555", "Ana Teo", "password", new GregorianCalendar(1700, 12, 12), "ana@email.com");
	private static Student student6 = new Student("s6666666", "Julie Nguyen", "password", new GregorianCalendar(0001, 1, 1), "julie@email.com");
	
	private static SysAdmin sysAdmin1 = new SysAdmin("a1111111", "Halil", "password");
	
	// add courses
	
	
	//add Programs
	private static Program program1 = new Program("BP094", 1, 48, true, ProgramType.BACHELOR);
	private static Program progtam2 = new Program("BP129", 2, 48, true, ProgramType.BACHELOR);
	private static Program progtam3 = new Program("BP229", 3, 48, true, ProgramType.BACHELOR);
	private static Program progtam4 = new Program("BP254", 4, 48, true, ProgramType.BACHELOR);
	
	


	public static void init() {
		//enrol students in courses
		
		
		users.add( student1);
		users.add( student2);
		users.add( student3);
		users.add( student4);
		users.add( student5);
		users.add( student6);
		users.add(sysAdmin1);
	}
	
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

	@SuppressWarnings("unchecked")
	void fetchStoredData() {
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

	void saveStoredData() {
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
