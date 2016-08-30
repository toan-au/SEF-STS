package com.model;

import java.io.File;
import java.util.ArrayList;

public class Coordinator extends AdvancedUser {
	
	private boolean meetRequirements;
	
	public Coordinator(String id, String name, String password, boolean meetRequirements)
	{
		super(id, name, password);
		this.meetRequirements = meetRequirements;
	}
	
	public boolean getMeetRequirements()
	{
		return meetRequirements;
	}
	
	public setMeetRequirements(boolean meetRequirements)
	{
		this.meetRequirements = meetRequirements;
	}
	
	ArrayList<Student> meetsProgramRequirement(File file, boolean meetRequirements) 
	{
		//Commented textfile is filepath
		//Read each student from file
		Scanner student = new Scanner(new File("/*students.txt*/");
		ArrayList<Student> students = new ArrayList<Student>();
		while (student.hasNext())
		{
			students.add(student.next());
		}
		student.close();
		//test - Student Ana = new Student(1, 12)
		//test - students.add(Ana);
		//tempo code to get an idea of what's going to happen in this block
		if(students.getCredits() == 12)
		{
			return true;
		}
		
		return false;

	}
}
