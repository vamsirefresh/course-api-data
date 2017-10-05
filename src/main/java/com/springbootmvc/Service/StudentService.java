package com.springbootmvc.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootmvc.DAO.StudentDAO;
import com.springbootmvc.Entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDAO studentDao;
	
	public Collection<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}
	
	public Student getStudentById(int id)
	{
		return studentDao.getStudentById(id);
	}
}
