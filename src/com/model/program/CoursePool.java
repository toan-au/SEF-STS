package com.model.program;

import java.util.ArrayList;

import com.model.CourseDoesNotExistException;
import com.model.Storage;

public class CoursePool implements Specializations {

	ArrayList<String> coursePool;

	public CoursePool() {
		coursePool = new ArrayList<>();
	}

	@Override
	public void addCourse(String courseId) throws CourseDoesNotExistException {
		if (null == Storage.getCourse(courseId))
			throw new CourseDoesNotExistException();

		coursePool.add(courseId);
	}

	@Override
	public ArrayList<String> getCourses() {
		return coursePool;
	}

	@Override
	public void removeCourse(String courseId) {
		//TODO: Message if course didn't exist?
		if(!coursePool.remove(courseId))
			System.out.println("Course " + courseId + " is not part of the course pool.");
	}

	//FixedSet methods
	@Override
	public void addSet(String setName) throws WrongSpecModeException {
		throw new WrongSpecModeException();
	}

	@Override
	public SingleSet getSet(String setName) throws WrongSpecModeException {
		throw new WrongSpecModeException();
	}

	@Override
	public ArrayList<SingleSet> getAllSets() throws WrongSpecModeException {
		throw new WrongSpecModeException();
	}

	@Override
	public void removeSet(String setname) throws WrongSpecModeException {
		throw new WrongSpecModeException();
	}

}
