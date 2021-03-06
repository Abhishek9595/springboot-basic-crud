package com.spring.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.crud.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findById(int id);

}
