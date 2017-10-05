package com.springboot.quickstart.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	// you are not creating this service, SPRING is going to instantiate..by declaring the DEPENDENCY
	@Autowired
	private TopicService topicSvc;
	
	// GET   /topics     : Get All topics
	//@RequestMapping(value="/topics", method = RequestMethod.GET, produces = { "application/json", "application/xml", "text/xml" })
	@RequestMapping(value="/topics", method = RequestMethod.GET)
	@ResponseBody
	public List<Topic> getAllTopics()
	{
		return topicSvc.getAllTopics();	
	}
	
	
	
	
	// GET   /topics/id  : Get the topic
	@RequestMapping(value="/topics/{id}", method=RequestMethod.GET)
	public Topic getTopic(@PathVariable String id)
	{
		return topicSvc.getTopic(id); 
	}
	
	
	// POST   /topics    : Create New Topic
	@RequestMapping(value="/topics", method=RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {
		
		topicSvc.addTopic(topic);
	}
	
	
	// PUT  /topics/id   : update the Topic
	@RequestMapping(value="/topics/{id}", method=RequestMethod.PUT)
	public void updateTopic(@RequestBody Topic t, @PathVariable String id) {
		topicSvc.updateTopic(t, id);
	}
	
	// DELETE /topics/id : delete the Topic
	@RequestMapping(value="/topics/{id}", method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id)
	{
		topicSvc.deleteTopic(id); 
		return;
	}
}
