package com.spring.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.model.Student;
import com.spring.crud.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Override
	public Student addStudent(Student student) {
		return repository.save(student);
	}

	@Override
	public Student fetchStudent(int id) {
		return repository.findById(id);
	}

}
