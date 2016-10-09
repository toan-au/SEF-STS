package com.model;

import java.util.ArrayList;

public class FixedSet implements Specializations {

	ArrayList<SingleSet> specializationSets;
	SingleSet currentSet;

	public FixedSet() {
		specializationSets = new ArrayList<>();
	}

	@Override
	public void addCourse(String courseId) throws CourseDoesNotExistException {
		currentSet.add(courseId);
	}

	@Override
	public ArrayList<String> getCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCourse(String courseId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSet(String setName) {
		specializationSets.add(new SingleSet(setName));

	}

	@Override
	public SingleSet getSet(String setName) {
		for (SingleSet set : specializationSets) {
			if (set.getName().equals(setName))
				currentSet = set;
		}
		return currentSet;
	}

	@Override
	public ArrayList<SingleSet> getAllSets() {
		return specializationSets;
	}

	@Override
	public void removeSet(String setName) {
		specializationSets.remove(getSet(setName));

	}

}
