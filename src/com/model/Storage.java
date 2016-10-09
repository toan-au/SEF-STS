package com.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import com.model.program.Program;
import com.model.program.ProgramType;
import com.model.program.SpecializationMode;
import com.model.users.Student;
import com.model.users.SysAdmin;
import com.model.users.User;

public class Storage {
	public static ArrayList<User> users = new ArrayList<>();
	public static ArrayList<Course> courses = new ArrayList<>();
	public static ArrayList<Program> programs = new ArrayList<>();
	public static ArrayList<CourseEnrolment> courseEnrolments = new ArrayList<>();

	@SuppressWarnings("unused")
	public static void init() {
		Student tempStudent = new Student("s1111111", "Toan Au", "password", new GregorianCalendar(1993, 12, 25), "toan@email.com");
		tempStudent = new Student("s2222222", "Bob Builder", "password", new GregorianCalendar(1990, 1, 1), "bob@email.com");
		tempStudent = new Student("s3333333", "Harold Senpai", "password", new GregorianCalendar(1999, 6, 13), "harold@email.com");
		tempStudent = new Student("s4444444", "Sophie Au", "password", new GregorianCalendar(1800, 5, 25), "sophie@email.com");
		tempStudent = new Student("s5555555", "Ana Teo", "password", new GregorianCalendar(1700, 12, 12), "ana@email.com");
		tempStudent = new Student("s6666666", "Julie Nguyen", "password", new GregorianCalendar(0001, 1, 1), "julie@email.com");
		SysAdmin tempSysAd = new SysAdmin("a1111111", "Halil", "password");

		Course tempCourse = new Course("COSC2102B", "Software Engineering Project (PtB)", 4);
		tempCourse = new Course("AERO2394", "Aeronautical Design", 4);
		tempCourse = new Course("EEET2032", "Simulation Based Design", 4);
		tempCourse = new Course("ISYS1013", "Systems Design", 4);
		tempCourse = new Course("GRAP2324", "Advanced Imaging in 2D and 3D", 4);
		tempCourse = new Course("VART2992", "3D Animation Advanced", 4);
		tempCourse = new Course("GRAP2326", "3D Character: Create and Animate and Special Effects", 4);
		tempCourse = new Course("INTE1033", "E-Commerce Development 2", 4);
		tempCourse = new Course("ISYS2064", "Applications Development for PCs - Spreadsheets", 4);
		tempCourse = new Course("MKTG1227", "Theory Development and Critical Analysis", 4);
		tempCourse = new Course("HUSO2177", "Practicing Development", 4);
		tempCourse = new Course("BUIL1161", "International Development", 4);

		Program tempProgram = new Program("BP094", "IT", 1, 48, true, ProgramType.BACHELOR, SpecializationMode.COURSEPOOL);
		tempProgram = new Program("BP129", "CompSci", 2, 48, true, ProgramType.BACHELOR, SpecializationMode.COURSEPOOL);
		tempProgram = new Program("BP229", "SEF", 3, 48, true, ProgramType.BACHELOR, SpecializationMode.COURSEPOOL);
		tempProgram = new Program("BP254", "Computer Studies", 4, 48, true, ProgramType.BACHELOR, SpecializationMode.COURSEPOOL);

		Student toan = (Student) Storage.getUser("s1111111");

		// enrol students in courses
		toan.enrolCourse("COSC2102B", 2, 2016);
		toan.enrolCourse("AERO2394", 2, 2016);
		toan.enrolCourse("GRAP2324", 2, 2016);
		toan.enrolCourse("HUSO2177", 2, 2016);
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

	@SuppressWarnings({ "unchecked", "resource" })
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

	@SuppressWarnings("resource")
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

	public static String print() {
		StringBuilder allEntries = new StringBuilder();
		allEntries.append("Users:\n" + printUsers() + "\n");
		allEntries.append("Courses:\n" + printCourses() + "\n");
		allEntries.append("Programs:\n" + printPrograms() + "\n");
		return allEntries.toString();

	}

	// List all data
	public static String printUsers() {
		StringBuilder userString = new StringBuilder();
		for (User user : users)
			userString.append(user + "\n");

		return userString.toString();
	}

	public static String printCourses() {
		StringBuilder courseString = new StringBuilder();
		for (Course course : courses)
			courseString.append(course + "\n");

		return courseString.toString();
	}

	public static String printPrograms() {
		StringBuilder programString = new StringBuilder();
		for (Program program : programs)
			programString.append(program + "\n");

		return programString.toString();
	}

}
