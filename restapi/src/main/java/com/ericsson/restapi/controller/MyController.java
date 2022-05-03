package com.ericsson.restapi.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericsson.restapi.entities.Course;
import com.ericsson.restapi.services.CourseService;

@RestController
@RequestMapping("/courses")
public class MyController {
	
	Logger LOGGER = LoggerFactory.getLogger(MyController.class);
	
	@Autowired
	private CourseService courseservice;
	
//	@GetMapping("/home")
//	public String home() {
//		return "Welcome To My Home";
//	}
//	
//	// get the courses
//	
	@GetMapping({"/v1.0","v1.1"})
	public List<Course> getCourses(){	
		LOGGER.info("[MyController] - Inside getCourses Method");
		return this.courseservice.getCourses();
		
	}
	
	@GetMapping({"/v1.0/{courseId}"})
	public Course getCourse(@PathVariable String courseId) {
		LOGGER.info("[MyController] - Inside getCourse Method");
		return this.courseservice.getCourseById(Long.parseLong(courseId));
	}

//	@PostMapping({"/v1.0"})
//	public Course addCourse(@RequestBody Course course) {
//		return this.courseservice.addCourse(course);
//	}
//	

	@PostMapping({"/v1.0","v1.1"})
	// http://localhost:7070/categories/v1.0
	// http://localhost:7070/categories/v1.0
	public Course addCourse(@RequestBody Course course) {
		return this.courseservice.addCourse(course);
	}
	
	@PutMapping("{/v1.0}")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseservice.updateCourse(course);
	}
	
//	@DeleteMapping("/courses/{courseId}")
//	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
//		try {
//			this.courseservice.deleteCourse(Long.parseLong(courseId));
//			return new ResponseEntity<>(HttpStatus.OK);
//		
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//			
//		}
	}


