package com.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Scanner;

import com.controller.Storage;
import com.view.StudentProgressSystem;

@SuppressWarnings("serial")
public class User implements Serializable {
	protected String name;
	protected String id;
	protected String password;
	private Role role;

	// TODO: Is the ID going to be generated or assigned??
	public User(String id, String name, String password, Role role) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
		Storage.users.add(this);
	}

	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCoreCourses(ArrayList<Course> course) {
		//called by program.setCoreCourses(courses);
	}

	public ArrayList<Student> meetsProgramRequirement(File file, boolean meetRequirements) {
		Scanner student;
		ArrayList<Student> students = new ArrayList<Student>();

		try {
			student = new Scanner(new File("/*students.txt*/"));

			while (student.hasNext()) {
				// students.add(student.next());
			}
			student.close();
			// test - Student Ana = new Student(1, 12)
			// test - students.add(Ana);
			// tempo code to get an idea of what's going to happen in this block
			for (Student s : students) {
				// if (s.getCredits() == 12)
				System.out.println("The student meets the program requirements.");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return students;
	}

	
	public Map<Course, Double> checkStudentResults(Student student) {
		return student.getCourses();
	}

	public boolean meetsCourseCompletion(Student student, Course course) {
		return false;
	}

	
	public void setCreditPointsNeeded(Program program, int credits) {

	}

	public void setCoreCourses(Program program, ArrayList<Course> course) {

	}

	public void setSpecializationCourses(Program program, ArrayList<Course> courses, String specialization, SpecializationMode mode) {

	}

	public void setSpecializationCourses(Program program, ArrayList<Course> courses, String specialization) {

	}
	public void createStudentAccount() {
		System.out.println("Enter the student's ID");
		String inputId = StudentProgressSystem.scanner.next();

		System.out.println("Enter the student's password");
		String inputPassword = StudentProgressSystem.scanner.next();

		System.out.println("Enter the student's Name");
		String inputName = StudentProgressSystem.scanner.next();

		createStudentAccount(inputId, inputPassword, inputName);
	}

	protected void createStudentAccount(String userId, String password, String fullName) {
		System.out.println("Please enter the student's birthday like so: DD/MM/YYYY");
		StudentProgressSystem.scanner.useDelimiter("/");
		int day = StudentProgressSystem.scanner.nextInt();
		int month = StudentProgressSystem.scanner.nextInt();
		int year = StudentProgressSystem.scanner.nextInt();
		StudentProgressSystem.scanner.reset();

		System.out.println("Please enter the student's email.");
		String email = StudentProgressSystem.scanner.next();

		@SuppressWarnings("unused")
		Student student = new Student(userId, fullName, password, new GregorianCalendar(year, month, day), email);

		System.out.println("You have just created an account with the user name " + userId + "and password " + password + ".\n"
				+ "This account is now ready to be used.");
	}

	public void createStudentAccount(ArrayList<Student> student) {

	}

	public void uploadEnrolment(Student student, Map<Course, Double> enrolments) {

	}

	public void uploadEnrolment(Map<Student, Map<Course, Double>> enrolments) {

	}

	
	public void createAccount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Create a new User Account:\n" + "Please add an Id:");
		String userId = scanner.next();
		System.out.println("Please add a password:");
		String password = scanner.next();
		System.out.println("Please add the user's name:");
		String fullName = scanner.nextLine();

		if (userId.startsWith("a")) {
			Storage.users.add(new User(userId, fullName, password, Role.SYSADMIN));

		} else if (userId.startsWith("c")) {
			Storage.users.add(new User(userId, fullName, password, Role.COORDINATOR));

		} else if (userId.startsWith("f")) {
			Storage.users.add(new User(userId, fullName, password, Role.FACADMIN));

		} else if (userId.startsWith("s")) {
			createStudentAccount(userId, password, fullName);
		} else {
			System.out.println("The account name you have entered is not valid");
			scanner.close();
			return;
		}
		if (!userId.startsWith("s"))
			System.out.println("You have just created an account with the user name " + userId + "and password " + password + ".\n"
					+ "This account is now ready to be used..");
		scanner.close();
	}

	public void setUpNewProgram() {
		System.out.println("Enter the Program's Code");
		String inputProgramCode = StudentProgressSystem.scanner.next();

		System.out.println("Enter the Version Number");
		int inputVersionNumber = StudentProgressSystem.scanner.nextInt();

		System.out.println("Enter the Program's Credit");
		int inputRequiredCredits = StudentProgressSystem.scanner.nextInt();

		System.out.println("Is the program active? true/false");
		boolean inputIsActive = StudentProgressSystem.scanner.nextBoolean();

		ProgramType inputProgramType = null;
		while (inputProgramType == null) {
			System.out.println("Enter the Program's type");
			String tempProgramType = StudentProgressSystem.scanner.next().toUpperCase();

			if (tempProgramType.equals("BACHELOR"))
				inputProgramType = ProgramType.BACHELOR;
			else if (tempProgramType.equals("HONOURS"))
				inputProgramType = ProgramType.HONOURS;
			else if (tempProgramType.equals("GRADDIPLOMA"))
				inputProgramType = ProgramType.GRADDIPLOMA;
			else if (tempProgramType.equals("MASTERS"))
				inputProgramType = ProgramType.MASTERS;
			else
				System.out.println("This type is not exist!!");
		}
		// System.out.println("Enter the Core Course");
		// tempProgramType = input.next();
		// if (tempProgramType.equals("CoreCourse1")){
		// inputCoreCourses = Storage.courses[0];
		// }else if (tempProgramType.equals("CoreCourse2")){
		// inputCoreCourses = Storage.courses[1];
		// }else if (tempProgramType.equals("CoreCourse3")){
		// inputCoreCourses = Storage.courses[2];
		// }else{
		// System.out.println("This course is not exist!!");
		// }
		//
		// System.out.println("Enter the Specialization Mode");
		// tempSpMode = input.next();
		// //change input to upper case
		// tempSpMode = tempSpMode.toUpperCase();
		//
		// if (tempSpMode.equals("FIXEDSET")){
		// inputSpecializationMode = SpecializationMode.FIXEDSET;
		// }else if (tempSpMode.equals("COURSEPOOL")){
		// inputSpecializationMode = SpecializationMode.COURSEPOOL;
		// }else{
		// System.out.println("This Mode is not exist!!");
		// }
		//
		// System.out.println("Enter the Specialization");
		// inputSpecializations = input.next();

		Program newProgram = new Program(inputProgramCode, inputVersionNumber, inputRequiredCredits, inputIsActive, inputProgramType);

		// Store the new course to the array.
		Storage.programs.add(newProgram);

		// inform user that the program has been created
		System.out.println("Program " + newProgram.getProgramCode() + " has been created and added to the database");
	}
	
	
	
	public String toString(){
		return "\n" + id + " " + name;
		
	}

}
