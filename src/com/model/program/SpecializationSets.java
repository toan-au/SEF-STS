package com.model.program;

import java.io.Serializable;
import java.util.ArrayList;

import com.model.Course;
import com.model.Storage;

@SuppressWarnings("serial")
public class SpecializationSets implements Serializable{

	ArrayList<SingleSet> specializationSets;
	SingleSet currentSet;
	SpecializationMode mode;

	public SpecializationSets(SpecializationMode mode) {
		specializationSets = new ArrayList<>();
		this.mode = mode;
		if (mode == SpecializationMode.COURSEPOOL)
			specializationSets.add(new SingleSet("course pool"));
	}

	public void addSet(String setName) {
		if (mode == SpecializationMode.COURSEPOOL) {
			System.out.println("nope");
			return;
		}
		specializationSets.add(new SingleSet(setName));
	}

	public void removeSet(String setName) {
		if (mode == SpecializationMode.COURSEPOOL) {
			System.out.println("nope");
			return;
		}
		specializationSets.remove(getSet(setName));
	}

	public SingleSet getSet(String setName) {
		for (SingleSet set : specializationSets) {
			if (set.getName().equals(setName))
				return set;
		}
		return null;
	}

	public ArrayList<SingleSet> getAllSets() {
		return specializationSets;
	}

	public void addCourse(ArrayList<String> course) {
		if (mode != SpecializationMode.COURSEPOOL) {
			System.out.println("A set needs to be selected");
			return;
		}
		addCourse("course pool", course);
	}

	public void addCourse(String set, ArrayList<String> courses) {
		for (String course : courses)
			getSet(set).add(Storage.getCourse(course));
	}

	public void removeCourse(Course... course) {
		if (mode != SpecializationMode.COURSEPOOL) {
			System.out.println("A set needs to be selected");
			return;
		}
		removeCourse("course pool", course);
	}

	public void removeCourse(String set, Course... courses) {
		for (Course course : courses)
			getSet(set).add(course);
	}

	public ArrayList<Course> getCourses() {
		ArrayList<Course> courses = new ArrayList<>();
		for (SingleSet set : specializationSets)
			courses.addAll(set.getCourses());
		return courses;
	}

}
