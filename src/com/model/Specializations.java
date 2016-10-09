package com.model;

import java.util.ArrayList;
import java.util.Map;

public interface Specializations {

	void addCourse(String courseId) throws CourseDoesNotExistException;

	ArrayList<String> getCourses();

	void removeCourse(String courseId);

	// Fixed Set only
	void addSet(String setName) throws WrongSpecModeException;

	SingleSet getSet(String setName) throws WrongSpecModeException;

	ArrayList<SingleSet> getAllSets() throws WrongSpecModeException;

	void removeSet(String setName) throws WrongSpecModeException;

}
