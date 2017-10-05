package com.springbootmvc.DAO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springbootmvc.Entity.Student;

// make this a repository
@Repository 
public class StudentDAO {

	private static Map<Integer, Student> students;
	
	// this can be the first step in POC, it can be later replaced with DB
	static {
		students = new HashMap<Integer, Student>();
		{
			students.put(1, new Student(1, "John", "Computer Sciencce"));
			students.put(2, new Student(2, "Henry", "Finance"));
			students.put(3, new Student(3, "Moore", "Math"));
		}
	}
	
	public Collection<Student> getAllStudents() {
		return this.students.values();
	}
	
	public Student getStudentById(int id)
	{
		return this.students.get(new Integer(id));
	}
}
