package com.model.users;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;
import com.model.Course;
import com.model.CourseEnrolment;
import com.model.Storage;
import com.model.program.Program;
import com.model.program.SpecializationMode;
import com.Global;

@SuppressWarnings("serial")
public class AdvancedUser extends User {

	public AdvancedUser(String id, String name, String password) {
		super(id, name, password);
		Storage.users.add(this);
	}

	public static void editProgram() {
		Program program;

		while (true) {
			System.out.println("Enter the ID of the program you would like to edit: ");
			program = Storage.getProgram(Global.scanner.next());

			if (program == null) {
				System.out.println("No program with that ID code. Please try again: ");
				continue;
			}

			// show user menu how they can edit programs
			System.out.println("How would you like to edit \"" + program.getProgramCode() + "\"");
			System.out.println("1 - Set credit points needed");
			System.out.println("2 - Set core courses");
			System.out.println("3 - Set specialization courses");
			System.out.println("4 - back");

			switch (Global.convertInputToInteger(Global.scanner.next())) {
			case 1: // set credit points
				System.out.println("How many credit points would you like " + program.getProgramCode() + " to require? ");
				program.setRequiredCredits(Global.convertInputToInteger(Global.scanner.next()));
				System.out.println(program.getProgramCode() + "'s credit points have been set to " + program.getRequiredCredits());
				break;

			case 2: // Setting core courses
				System.out.println("Please enter the course ids, one per line. Cancel by entering 'q':");
				while (true) {
					String courseId = Global.scanner.next();
					if (courseId.equals("q"))
						break;
					program.setCoreCourse(courseId);
				}
				break;

			case 3: // setting spec courses
				String setName;
				if (program.getSpecializationMode() == SpecializationMode.FIXEDSET) {
					System.out.println("Please specify the set you would like to add/extend:");
					setName = Global.scanner.next();
				} else
					setName = "course pool";

				System.out.println("Please enter the course ids, one per line. Cancel by entering 'q':");
				while (true) {
					String courseId = Global.scanner.next();
					if (courseId.equals("q"))
						break;
					program.setSpecializations(setName, courseId);
				}
				break;

			case 4:
				return;
			default:
				System.out.println("That isn't an option, please try again.");
				break;
			}
		}
	}

	public static void createStudentAccount() {
		System.out.println("Enter the student's ID");
		String inputId = Global.scanner.next();

		System.out.println("Enter the student's Name");
		String inputName = Global.scanner.next();

		System.out.println("Enter the student's password");
		String inputPassword = Global.scanner.next();

		createStudentAccount(inputId, inputName, inputPassword);
	}

	protected static void createStudentAccount(String userId, String fullName, String password) {
		System.out.println("Please enter the student's birthdate (day only)");
		int day = Global.scanner.nextInt();
		System.out.println("Please enter the student's birth month");
		int month = Global.scanner.nextInt();
		System.out.println("Please enter the student's birth year");
		int year = Global.scanner.nextInt();

		System.out.println("Please enter the student's email.");
		String email = Global.scanner.next();

		Student student = new Student(userId, fullName, password, new GregorianCalendar(year, month, day), email);

		System.out.println("You have just created an account with the user name " + student.getId() + " and password " + student.getPassword() + ".\n"
				+ "This account is now ready to be used.");
	}

	@SuppressWarnings({ "resource", "unused" })
	public static void createStudentAccounts() {
		String userId, fullName, password, email, birthday;
		String line;
		BufferedReader reader = null;
		int resultDay, resultMonth, resultYear;
		int studentCount = 0;
		resultDay = 0;
		resultMonth = 0;
		resultYear = 0;

		System.out.println("What is the name of your file?");

		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(Global.scanner.next())));

			while ((line = reader.readLine()) != null) {
				// use ":" to split the file
				String[] resultMember = line.split(":");
				userId = resultMember[0];
				fullName = resultMember[1];
				password = resultMember[2];
				birthday = resultMember[3];
				email = resultMember[4];

				// use "/" to split birthday
				String[] birthdayString = birthday.split("/");
				resultDay = Integer.parseInt(birthdayString[0]);
				resultMonth = Integer.parseInt(birthdayString[1]);
				resultYear = Integer.parseInt(birthdayString[2]);

				// create new student
				Student student = new Student(userId, fullName, password, new GregorianCalendar(resultYear, resultMonth, resultDay), email);
				studentCount++;
				System.out.println(studentCount + " student accounts have been created");
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("Error reading the file.");
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println("Couldn't close reader");
				}
			}
		}
	}

	public static void createEnrolment() {
		Student student;
		Course course;
		int semester, year;

		while (true) {
			System.out.println("Who do you wish to enrol into a course. Enter the student's ID");
			student = Storage.getStudent(Global.scanner.next());
			if (student == null) {
				System.out.println("No student by that ID. please try again");
				continue;
			}

			System.out.println("Which course do you want to enrol them in? Please enter its ID");
			course = Storage.getCourse(Global.scanner.next());
			if (course == null) {
				System.out.println("No course by that ID. please try again");
				continue;
			}

			System.out.println("Which semester are they enroling into?");
			semester = Integer.parseInt(Global.scanner.next());

			System.out.println("Which year are they enroling into?");
			year = Integer.parseInt(Global.scanner.next());

			CourseEnrolment courseEnrolment = new CourseEnrolment(student, course, semester, year);
			System.out.println(courseEnrolment.getStudent().getName() + " has been enrolled into " + courseEnrolment.getCourse().getCourseId());
			return;
		}
	}

	@SuppressWarnings("resource")
	public static void uploadEnrolments() {
		String studentID, courseID;
		String line;
		Student resultStudent;
		Course resultCourse;
		CourseEnrolment courseEnrolment;
		BufferedReader reader = null;
		int year, semester, i, j;
		int studentCount = 0;
		year = 2016;
		semester = 1;
		i = 0;
		j = 0;

		System.out.println("What is the name of your file?");
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(Global.scanner.next()))));
			// use while loop to read the line
			while ((line = reader.readLine()) != null) {
				studentCount++;
				// use ":" to split the file
				String[] resultMember = line.split(":");
				if (resultMember.length == 24) {
					j = 6;
					while (j > 0) {
						// set different variables, and give them value
						studentID = resultMember[0];
						resultStudent = Storage.getStudent(studentID);
						for (i = 1; i < 5; i++) {
							courseID = resultMember[i];
							resultCourse = Storage.getCourse(courseID);

							if (courseID.length() >= 9) {
								courseID = courseID.substring(0, courseID.length() - 1);
								courseEnrolment = new CourseEnrolment(studentID, courseID, semester, year, true);
							} else {
								// create new student

								courseEnrolment = new CourseEnrolment(resultStudent, resultCourse, semester, year);
							}
							resultStudent.enrolCourse(courseEnrolment);
							System.out.println(courseID);
							// System.out.println(resultStudent.getName() + courseEnrolment.getCourse());
						}
						year++;
						semester++;
						j--;
					}
				} else if (resultMember.length == 16) {
					j = 4;
					while (j > 0) {
						// set different variables, and give them value
						studentID = resultMember[0];
						resultStudent = Storage.getStudent(studentID);
						for (i = 1; i < 5; i++) {
							courseID = resultMember[i];
							resultCourse = Storage.getCourse(courseID);

							if (courseID.length() >= 9) {
								courseID = courseID.substring(0, courseID.length() - 1);
								courseEnrolment = new CourseEnrolment(studentID, courseID, semester, year, true);
							} else {
								// create new student
								courseEnrolment = new CourseEnrolment(resultStudent, resultCourse, semester, year);
							}
							resultStudent.enrolCourse(courseEnrolment);
							System.out.println(courseID);
							// System.out.println(resultStudent.getName() + courseEnrolment.getCourse());

						}
						year++;
						semester++;
						j--;
					}
				} else if (resultMember.length == 8) {
					j = 2;
					while (j > 0) {
						// set different variables, and give them value
						studentID = resultMember[0];
						resultStudent = Storage.getStudent(studentID);
						for (i = 1; i < 5; i++) {
							courseID = resultMember[i];
							resultCourse = Storage.getCourse(courseID);
							// create new student
							if (courseID.length() >= 9) {
								courseID = courseID.substring(0, courseID.length() - 1);
								courseEnrolment = new CourseEnrolment(studentID, courseID, semester, year, true);
							} else {
								// create new student
								courseEnrolment = new CourseEnrolment(resultStudent, resultCourse, semester, year);
							}
							resultStudent.enrolCourse(courseEnrolment);
							System.out.println(courseID);
							// System.out.println(resultStudent.getName() + courseEnrolment.getCourse());
						}
						year++;
						semester++;
						j--;
					}
				} else {
					j = 1;
					while (j > 0) {
						// set different variables, and give them value
						studentID = resultMember[0];
						resultStudent = Storage.getStudent(studentID);
						for (i = 1; i < 5; i++) {
							courseID = resultMember[i];
							resultCourse = Storage.getCourse(courseID);
							if (courseID.length() >= 9) {
								courseID = courseID.substring(0, courseID.length() - 1);
								courseEnrolment = new CourseEnrolment(studentID, courseID, semester, year, true);
							} else {
								// create new student
								courseEnrolment = new CourseEnrolment(resultStudent, resultCourse, semester, year);
							}
							resultStudent.enrolCourse(courseEnrolment);
							System.out.println(courseID);
							// System.out.println(resultStudent.getName() + courseEnrolment.getCourse());
						}
						year++;
						semester++;
						j--;
					}
				}

				System.out.println(studentCount + " student is enrolled");
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found please try again. or enter 'q' to quit");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("error reading the file");
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println("Couldn't close reader");
					e.printStackTrace();
				}
			}

		}
	}
}
