package com.ericsson.restapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;

import com.ericsson.restapi.entities.Course;

@SpringBootTest
class RestapiApplicationTests {
	
	private static Course course;
	
	@BeforeAll
	public static void getCourseInstance() {
		course = new Course();
		
	}
	
	@Test
	void testCourse() {
		assertNotNull(course);
	}
	
	@ParameterizedTest
	@ValueSource(strings= {"Java","SpringBoot","Linux","Microservices"})
	void testCourseName(String name) {
		course.setTitle(name);
		assertTrue(course.getTitle().startsWith("L"));
	}

}
