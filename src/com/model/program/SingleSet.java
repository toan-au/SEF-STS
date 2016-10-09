/**
 * 
 */
package com.model.program;

import java.util.ArrayList;

public class SingleSet {
	ArrayList<String> courses;
	String setName;

	public SingleSet(String setName) {
		this.setName = setName;
		courses = new ArrayList<>();
	}

	public String getName() {
		return setName;
	}

	public void add(String courseId) {
		courses.add(courseId);
	}

}
