package com.spring.crud.service;

import com.spring.crud.model.Student;

public interface StudentService {

	Student addStudent(Student student);

	Student fetchStudent(int id);

}
