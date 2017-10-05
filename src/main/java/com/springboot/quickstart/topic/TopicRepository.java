package com.springboot.quickstart.topic;

import org.springframework.data.repository.CrudRepository;

// this is a data service. Lets first build the CRUD ops

public interface TopicRepository extends CrudRepository<Topic, String> {
	//getAllTopics()
	//getTopic(String id)
	// updateTopic(Topic t, String id)
	// deleteTopic(String id)
	
	
}
