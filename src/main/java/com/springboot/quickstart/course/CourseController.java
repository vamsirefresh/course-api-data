package com.springboot.quickstart.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.quickstart.topic.Topic;

@RestController
public class CourseController {

	// you are not creating this service, SPRING is going to instantiate..by declaring the DEPENDENCY
	@Autowired
	private CourseService courseSvc;
	
	// GET   /topics     : Get All topics
	@RequestMapping(value="/topics/{id}/courses", method = RequestMethod.GET)
	public List<Course> getAllCourses(@PathVariable String id)
	{
		return courseSvc.getAllCourses(id);	
	}
	
	
	// GET   /topics/id  : Get the topic
	@RequestMapping(value="/topics/{topicId}/courses/{id}", method=RequestMethod.GET)
	public Course getCourse(@PathVariable String id)
	{
		return courseSvc.getCourse(id); 
	}
	
	
	// POST   /topics    : Add New Course
	@RequestMapping(value="/topics/{topicId}/courses", method=RequestMethod.POST)
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) 
	{
		course.setTopic(new Topic(topicId, "", ""));
		courseSvc.addCourse(course);
	}
	
	
	// PUT  /topics/id   : update the Topic
	@RequestMapping(value="/topics/{topicId}/courses/{id}", method=RequestMethod.PUT)
	public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId) 
	{
		course.setTopic(new Topic(topicId, "", ""));
		courseSvc.updateCourse(course);
	}
	
	// DELETE /topics/id : delete the Topic
	@RequestMapping(value="/topics/{topicId}/cousrse/{id}", method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable String id)
	{
		courseSvc.deleteCourse(id); 
		return;
	}
}
