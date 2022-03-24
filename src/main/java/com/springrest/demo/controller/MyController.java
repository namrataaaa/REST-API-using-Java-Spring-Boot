package com.springrest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.demo.entities.Course;
import com.springrest.demo.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;

	@GetMapping("/home")
	public String home() {
		return "this is the home page";
	}
	
	// get the courses
	@GetMapping("/courses")
	public List<Course> getCourses() {
		return this.courseService.getCourses();
	}
	
	//get single course
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	// add new course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	// update course
	@PutMapping("/courses/{courseId}")
	public Course updateCourse(@RequestBody Course course, @PathVariable String courseId) {
		return this.courseService.updateCourse(course, Long.parseLong(courseId));
	}
	
	//delete course
	@DeleteMapping("/courses/{courseId}") 
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception E) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

