package com.springboot.quickstart.course;
// We need to map this Topic table as a database table.. Each instance of this class will go as row

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.springboot.quickstart.topic.Topic;

@Entity
//@Table(name="Courses", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Course {
	@Id
	private String id;
	private String name;
	private String description;
	
	// topic should be FKEY mapping.. how to establish a mapping between topic and course.. 
	// it is a MANY-ONE.. many courses to one topic
	// THIS SHOULD BE INITIALIZED IN CTOR
	@ManyToOne
	private Topic topic;
	
	public Course()	{
		
	}
	
	public Course(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId, "", "");
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
}
