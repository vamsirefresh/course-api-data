package com.springboot.quickstart.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// this is a data service. Lets first build the CRUD ops

public interface CourseRepository extends CrudRepository<Course, String> {
	//getAllCourses()
	//getCourses(String id)
	// updateCourses(Topic t, String id)
	// deleteCourses(String id)
	
	// this method will find all courses by the filter : name. Convention is findBy<fieldName>
	//public List<Course> findByName(String name);
	public List<Course> findByTopicId(String topicId);
	public List<Course> getCoursesByTopic(String topicId);
	
}
