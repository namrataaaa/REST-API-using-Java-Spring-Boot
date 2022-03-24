package com.springrest.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springrest.demo.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long> {
	
}
