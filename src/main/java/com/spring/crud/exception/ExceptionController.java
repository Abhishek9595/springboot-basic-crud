package com.spring.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.crud.response.ExceptionResponse;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(StudentNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<ExceptionResponse> studentNotFound(StudentNotFoundException exception) {
		return new ResponseEntity<>(new ExceptionResponse(true, exception.getMessage()), HttpStatus.NOT_FOUND);
	}
}
