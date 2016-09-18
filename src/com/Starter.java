package com;

import java.util.GregorianCalendar;

import com.controller.Storage;
import com.model.Course;
import com.model.Program;
import com.model.ProgramType;
import com.model.Role;
import com.model.Student;
import com.model.User;
import com.view.StudentProgressSystem;

public class Starter {

	public static int currentIDPosition;

	public static void main(String[] args) {
		init();
		StudentProgressSystem.run();
		cleanUp();
	}

	private static void init() {
		// Storage.fetchStoredData();
		createAndAddDummyData();
	}

	private static void cleanUp() {
		// Storage.saveStoredData();
	}

	@SuppressWarnings("unused")
	private static void createAndAddDummyData() {
		Student student1 = new Student("s1111111", "Toan Au", "password", new GregorianCalendar(1993, 12, 25), "toan@email.com");
		Student student2 = new Student("s2222222", "Bob Builder", "password", new GregorianCalendar(1990, 1, 1), "bob@email.com");
		Student student3 = new Student("s3333333", "Harold Senpai", "password", new GregorianCalendar(1999, 6, 13), "harold@email.com");
		Student student4 = new Student("s4444444", "Sophie Au", "password", new GregorianCalendar(1800, 5, 25), "sophie@email.com");
		Student student5 = new Student("s5555555", "Ana Teo", "password", new GregorianCalendar(1700, 12, 12), "ana@email.com");
		Student student6 = new Student("s6666666", "Julie Nguyen", "password", new GregorianCalendar(0001, 1, 1), "julie@email.com");

		User sysAdmin1 = new User("a1111111", "Halil", "password", Role.SYSADMIN);

		// add courses
		Course course1 = new Course("COSC2102B", "Software Engineering Project (PtB)", 4);
		Course course2 = new Course("AERO2394", "Aeronautical Design", 4);
		Course course3 = new Course("EEET2032", "Simulation Based Design", 4);
		Course course4 = new Course("ISYS1013", "Systems Design", 4);

		Course course5 = new Course("GRAP2324", "Advanced Imaging in 2D and 3D", 4);
		Course course6 = new Course("VART2992", "3D Animation Advanced", 4);
		Course course7 = new Course("GRAP2326", "3D Character: Create and Animate and Special Effects", 4);
		Course course8 = new Course("INTE1033", "E-Commerce Development 2", 4);

		Course course9 = new Course("ISYS2064", "Applications Development for PCs - Spreadsheets", 4);
		Course course10 = new Course("MKTG1227", "Theory Development and Critical Analysis", 4);
		Course course11 = new Course("HUSO2177", "Practicing Development", 4);
		Course course12 = new Course("BUIL1161", "International Development", 4);

		// add Programs
		Program program1 = new Program("BP094", 1, 48, true, ProgramType.BACHELOR);
		Program progtam2 = new Program("BP129", 2, 48, true, ProgramType.BACHELOR);
		Program progtam3 = new Program("BP229", 3, 48, true, ProgramType.BACHELOR);
		Program progtam4 = new Program("BP254", 4, 48, true, ProgramType.BACHELOR);

		student1.setCourse("COSC2102B");
		student1.setCourse("AERO2394");
		student1.setCourse("GRAP2324");
		student1.setCourse("HUSO2177");

		Storage.users.add(student1);
		Storage.users.add(student2);
		Storage.users.add(student3);
		Storage.users.add(student4);
		Storage.users.add(student5);
		Storage.users.add(student6);
		Storage.users.add(sysAdmin1);
	}
}
