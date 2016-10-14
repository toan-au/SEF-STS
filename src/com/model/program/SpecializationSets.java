package com.model.program;

import java.io.Serializable;
import java.util.ArrayList;

import com.model.Course;
import com.model.Storage;

@SuppressWarnings("serial")
public class SpecializationSets implements Serializable {

	ArrayList<SingleSet> specializationSets;
	SingleSet currentSet;
	SpecializationMode mode;

	public SpecializationSets(SpecializationMode mode) {
		specializationSets = new ArrayList<>();
		this.mode = mode;
		if (mode == SpecializationMode.COURSEPOOL)
			specializationSets.add(new SingleSet("course pool"));
	}
	
	public ArrayList<String> getSetNames(){
		ArrayList<String> setNames = new ArrayList<>();
		for (SingleSet set : specializationSets) {
			setNames.add(set.getName());
		}
		return setNames;
	}

	public ArrayList<SingleSet> getAllSets() {
		return specializationSets;
	}

	public SingleSet getSet(String setName) {
		for (SingleSet set : specializationSets) {
			if (set.getName().equals(setName))
				return set;
		}
		return null;
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

	public ArrayList<Course> getAllCourses() {
		ArrayList<Course> courses = new ArrayList<>();
		for (SingleSet set : specializationSets)
			courses.addAll(set.getCourses());
		return courses;
	}

	public ArrayList<Course> getCourses(String setName) {
		return getSet(setName).getCourses();
	}

	public void addCourse(String setName, String courseId) {
		getSet(setName).addCourse(Storage.getCourse(courseId));
	}

}
