package com.springboot.quickstart.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

// business services are SINGLETONS. When application starts up, Spring creates an instance of this service and registers this instance.
// so that other services or controllers that depends on this service (DEPENDENCY), will be able to inject into those other classes.


@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepo;
	
	public List<Course> getAllCourses(String topicId)
	{
		List<Course> courses = new ArrayList<>();
		courseRepo.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
	}
	

	public Course getCourse(String id)
	{
		return courseRepo.findOne(id);
	}
	

	public void addCourse(Course t)
	{
		courseRepo.save(t);
	}
	
	
	public void updateCourse(Course course)
	{
		courseRepo.save(course);
		return;
	}
	
	
	public void deleteCourse(String id)
	{
		courseRepo.delete(id);
		return;
	}
}
