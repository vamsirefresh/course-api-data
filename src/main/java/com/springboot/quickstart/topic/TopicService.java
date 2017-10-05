package com.springboot.quickstart.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

// business services are SINGLETONS. When application starts up, Spring creates an instance of this service and registers this instance.
// so that other services or controllers that depends on this service (DEPENDENCY), will be able to inject into those other classes.


@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepo;
	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList( 
			new Topic("1", "Spring Framework", "Spring Framework Description"), 
			new Topic("2", "Core Java", "Core Java Description"),
			new Topic("3", "JavaScript", "JavaScript Description")
			));
	
	public List<Topic> getAllTopics()
	{
		//return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepo.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id)
	{
		return topicRepo.findOne(id);
	}
	

	public void addTopic(Topic t)
	{
		//topics.add(t);
		topicRepo.save(t);
	}
	
	
	public void updateTopic(Topic topic, String id)
	{
		// you dont need this delete as save() can insert if not found or update
		// topicRepo.delete(id);
		topicRepo.save(topic);
		
//		for (int i = 0; i < topics.size(); i++) {
//			Topic t = topics.get(i);
//			if ( t.getId().equals(id))
//			{
//				topics.set(i, topic);
//				return;
//			}
//			
//		}
	return;
	}
	
	
	public void deleteTopic(String id)
	{
//		for (int i = 0; i < topics.size(); i++) {
//			Topic t = topics.get(i);
//			if ( t.getId().equals(id))
//			{
//				topics.remove(i);
//				return;
//			}
//			
//		}
		topicRepo.delete(id);
		return;
	}
}
