package com.ericsson.restapi.services;


import  com.ericsson.restapi.entities.Course;
import com.ericsson.restapi.repositories.DaoRepository;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseImp implements CourseService {
	
	@Autowired
	private DaoRepository daorepository;
	
//	List<Course> list;
//	
//	public CourseImp() {
//		list = new ArrayList<>();
//		list.add(new Course(1,"Core Java","Core Java Basic Book"));
//		list.add(new Course(2,"Advance Java","Advance Java Book"));
//	}

	@Override
	public List<Course> getCourses() {
	
		return daorepository.findAll();
	}

	
//	@Override
//	public Course getCourseById(long courseId) {
//		return daorepository.findById(courseId);
//			
//		Course c = null;
//		for(Course course:list)
//		{
//			if(course.getId()== courseId)
//			{
//				c = course;
//				break;
//			}
//			
//		}
//		
////		return c;
//	}

	@Override
	public Course addCourse(Course course) {
		return daorepository.save(course);
		 
	}

	@Override
	public Course updateCourse(Course course) {
		return daorepository.save(course);
	}

	@Override
	public void deleteCourse(Long courseId) {
		Course entity = daorepository.getOne(courseId);
		daorepository.delete(entity);

	}


	@Override
	public Course getCourseById(Long courseId) {
		return daorepository.findById(courseId).orElse(null);
	}




	
	
}
