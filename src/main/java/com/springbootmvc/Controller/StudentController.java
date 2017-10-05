package com.springbootmvc.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootmvc.Entity.Student;
import com.springbootmvc.Service.StudentService;

// this class will offload the request to StudentService which delegates to StudentDAO to get the data necessary.

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentSvc;

	@RequestMapping(method=RequestMethod.GET)
	public Collection<Student> getAllStudents()
	{
		return studentSvc.getAllStudents();
	}
}
