package com.springrest.demo.services;

import java.util.List;

import com.springrest.demo.entities.Course;

public interface CourseService {

	public List<Course> getCourses();
	public Course getCourse(long courseId);
	public Course addCourse(Course course);
	public Course updateCourse(Course course, long courseId);
	public void deleteCourse(long courseId);
}
