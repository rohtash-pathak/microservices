package com.ericsson.restapi.services;

import java.util.List;

import com.ericsson.restapi.entities.Course;

public interface CourseService {
	

	public List<Course> getCourses();
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void deleteCourse(Long courseId);
	public Course getCourseById(Long courseId);
}
