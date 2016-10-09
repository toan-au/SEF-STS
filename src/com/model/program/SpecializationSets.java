package com.model.program;

import java.util.ArrayList;

public class SpecializationSets {

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

	public void addCourse(String... courseId) {
		if (mode != SpecializationMode.COURSEPOOL) {
			System.out.println("A set needs to be selected");
			return;
		}
		addCourse("course pool", courseId);
	}

	public void addCourse(String set, String... courseId) {
		for (String id : courseId)
			getSet(set).add(id);
	}

	public void removeCourse(String... courseId) {
		if (mode != SpecializationMode.COURSEPOOL) {
			System.out.println("A set needs to be selected");
			return;
		}
		removeCourse("course pool", courseId);
	}

	public void removeCourse(String set, String... courseId) {
		for (String id : courseId)
			getSet(set).add(id);
	}

	public ArrayList<String> getCourses() {
		ArrayList<String> courses = new ArrayList<>();
		for (SingleSet set : specializationSets)
			courses.addAll(set.getCourses());
		return courses;
	}

}
