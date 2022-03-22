package com.spring.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.exception.StudentNotFoundException;
import com.spring.crud.model.Student;
import com.spring.crud.response.ResponseMessage;
import com.spring.crud.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class StudentResource {

	@Autowired
	private StudentService service;

	@PostMapping("/add-student")
	public ResponseEntity<ResponseMessage> addStudent(@RequestBody Student student) {
		Student addStudent = service.addStudent(student);
		log.info("Student Added Successfully{}" + addStudent);
		return new ResponseEntity<>(new ResponseMessage(false, "Student Added Successfully", addStudent),
				HttpStatus.OK);
	}

	@GetMapping("/find-student/{id}")
	public ResponseEntity<ResponseMessage> findStudent(@PathVariable int id) {
		Student fetchStudent = service.fetchStudent(id);
		if (fetchStudent != null) {
			log.info("Student Fetched Successfully{}" + fetchStudent);
			return new ResponseEntity<>(new ResponseMessage(false, "Student Fetched Successfully", fetchStudent),
					HttpStatus.OK);
		} else {
			log.error("Student Not Found");
			throw new StudentNotFoundException("Student Not Found....");
		}
	}
}
