package com.springrest.demo.services;

import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.demo.dao.CourseDao;
import com.springrest.demo.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
//	List<Course> list;

	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(145, "Java Core Course", "This course contains all core java concepts"));
//		list.add(new Course(155, "Spring Boot Course", "This course contains all basic spring boot concepts"));
	}

	@Override
	public List<Course> getCourses() {
//		return list;
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
//		for (Course course : list) {
//			if (course.getId() == courseId) {
//				return course;
//			}
//		}
//		return null;
		
		return courseDao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
//		list.add(course);
		
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course, long courseId) {
//		list.forEach(c -> {
//			if (c.getId() == courseId) {
//				c.setTitle(course.getTitle());
//				c.setDescription(course.getDescription());
//			}
//		});
		
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
//		Iterator<Course> itr = list.iterator();
//		while (itr.hasNext()) {
//			Course course = itr.next();
//			if (course.getId() == courseId) {
//				itr.remove();
//			}
//		}
		
		Course entity = courseDao.getOne(courseId);
		courseDao.delete(entity);
	}

}
