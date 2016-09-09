package com;

import com.model.Coordinator;
import com.model.User;

public class StudentProgressSystem {
	
	User currentUser;
	
	public StudentProgressSystem() {
		
	}
	
	public void run() {
		validate();
	}
	
	private void validate() {
		Coordinator c1 = new Coordinator("e12345", "Matt", "password");
		c1.createStudentAccount();
		
		// prompt User for login
		
		// save user input as variables
		
		// see if the id given exists with Storage.getUser()
		
		// id it does then see if proided password matches the returned User's password
		
		// set currentUser to the returned User otherwise keep looping
	}
	
}
