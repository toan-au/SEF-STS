package com.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import com.Global;
import com.model.program.Program;
import com.model.program.ProgramType;
import com.model.program.SpecializationMode;
import com.model.users.Coordinator;
import com.model.users.Student;
import com.model.users.SysAdmin;
import com.model.users.User;

//FINISHED
public class Storage {
	public static ArrayList<User> users = new ArrayList<>();
	public static ArrayList<Student> students = new ArrayList<>();
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
		Coordinator coordinator1 = new Coordinator("c1111111", "Harold Zang", "password");

		Course tempCourse = new Course("COSC2102B", "Software Engineering Project (PtB)", 12);
		tempCourse = new Course("AERO2394", "Aeronautical Design", 12);
		tempCourse = new Course("EEET2032", "Simulation Based Design", 12);
		tempCourse = new Course("ISYS1013", "Systems Design", 12);
		tempCourse = new Course("GRAP2324", "Advanced Imaging in 2D and 3D", 12);
		tempCourse = new Course("VART2992", "3D Animation Advanced", 12);
		tempCourse = new Course("GRAP2326", "3D Character: Create and Animate and Special Effects", 12);
		tempCourse = new Course("INTE1033", "E-Commerce Development 2", 12);
		tempCourse = new Course("ISYS2064", "Applications Development for PCs - Spreadsheets", 12);
		tempCourse = new Course("MKTG1227", "Theory Development and Critical Analysis", 12);
		tempCourse = new Course("HUSO2177", "Practicing Development", 12);
		tempCourse = new Course("BUIL1161", "International Development", 12);

		Program tempProgram = new Program("BP094", "IT", 1, 48, true, ProgramType.BACHELOR, SpecializationMode.COURSEPOOL);
		tempProgram = new Program("BP129", "CompSci", 2, 48, true, ProgramType.BACHELOR, SpecializationMode.COURSEPOOL);
		tempProgram = new Program("BP229", "SEF", 3, 48, true, ProgramType.BACHELOR, SpecializationMode.COURSEPOOL);
		tempProgram = new Program("BP254", "Computer Studies", 4, 48, true, ProgramType.BACHELOR, SpecializationMode.COURSEPOOL);

		User toan = Storage.getStudent("s1111111");
		CourseEnrolment enrolment = new CourseEnrolment((Student)toan, tempCourse, 2, 2016);
		((Student)toan).enrolCourse(enrolment);
		
		loadCouseFile("coursefile.txt");
	}
	

	private static void loadCouseFile(String filename) {
		// TODO Auto-generated method stub
		String fileName, courseId, courseName, courseCredit;
		String line;
		File file;
		FileInputStream fis;
		InputStreamReader isr;
		BufferedReader reader;
		int resultCredit;
		int courseCount = 0;
		resultCredit = 0;
		

		fileName = "coursefile.txt";
		file = new File(fileName);

		try {
			fis = new FileInputStream(fileName);
			isr = new InputStreamReader(fis);
			reader = new BufferedReader(isr);
			//use while loop to read the line
			while((line = reader.readLine()) != null) {
				courseCount++;
				//use ":" to split the file
				String [] resultMember = line.split(":");
				//set different variables, and give them value
				courseId = resultMember[0];
				courseName = resultMember[1];
				courseCredit = resultMember[2];
				resultCredit = Integer.parseInt(courseCredit);
				
				//create new student
				@SuppressWarnings("unused")
				Course course = new Course(courseId, courseName, resultCredit);
				//System.out.println(courseCount + " Courses have been created");
			}
			System.out.println(" Courses load successful!");
		} catch (FileNotFoundException e) {
			System.out.println("File not found please try again. or enter 'q' to quit");
		} catch (IOException e) {
			System.out.println("error reading the file");
		}
		
	}


	public static User getUser(String id) {
		for (User user : users) {
			if (user.getId().equals(id))
				return user;
		}
		return null;
	}

	public static Student getStudent(String id) {
		for (Student student : students) {
			if (student.getId().equals(id))
				return student;
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
			students = (ArrayList<Student>) ois.readObject();
			System.out.println("Students loaded");
			courses = (ArrayList<Course>) ois.readObject();
			System.out.println("Courses loaded");
			programs = (ArrayList<Program>) ois.readObject();
			System.out.println("Programs loaded");
			courseEnrolments = (ArrayList<CourseEnrolment>) ois.readObject();
			System.out.println("Enrolments loaded");
			ois.close();
		} catch (@SuppressWarnings("unused") FileNotFoundException e) {
			System.out.println("No saved data was found. Proceeding to enter dummy data.\n");
			init();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Could not fetch saved data.\n");
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public static void saveStoredData() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ISL_filepath.dat"));
			oos.writeObject(users);
			System.out.println("Users saved");
			oos.writeObject(students);
			System.out.println("Students saved");
			oos.writeObject(courses);
			System.out.println("Courses saved");
			oos.writeObject(programs);
			System.out.println("Programs saved");
			oos.writeObject(courseEnrolments);
			System.out.println("Enrolments saved");
			oos.close();
		} catch (IOException e) {
			System.out.println("Could not save data.");
			try {
				Files.deleteIfExists(new File("ISL_filepath.dat").toPath());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public static String print() {
		StringBuilder allEntries = new StringBuilder();
		allEntries.append("Users:\n" + printUsers() + "\n");
		allEntries.append("Students:\n" + printStudents() + "\n");
		allEntries.append("Courses:\n" + printCourses() + "\n");
		allEntries.append("Programs:\n" + printPrograms() + "\n");
		allEntries.append("Enrolments:\n" + printEnrolments() + "\n");
		return allEntries.toString();
	}

	public static String printUsers() {
		StringBuilder userString = new StringBuilder();
		for (User user : users)
			userString.append(user + "\n");

		return userString.toString();
	}

	public static String printStudents() {
		StringBuilder studentString = new StringBuilder();
		for (Student student : students)
			studentString.append(student + "\n");

		return studentString.toString();
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

	private static String printEnrolments() {
		StringBuilder enrolmentString = new StringBuilder();
		for (CourseEnrolment enrolment : courseEnrolments)
			enrolmentString.append(enrolment + "\n");

		return enrolmentString.toString();
	}

}
