package com.gestaoAlunosapi.demo.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<String>> handleCpfIsEmpty(MethodArgumentNotValidException e){
		List<String> errors = new ArrayList<>();
	    e.getBindingResult().getAllErrors().forEach((error) -> {
	        String errorMessage = error.getDefaultMessage();
	        errors.add(errorMessage);
	    });	
	    
	    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errors);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> handleBodyNotReadable(){
		String error = "Body not valid.";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	
	@ExceptionHandler(CpfNotFoundException.class)
	public ResponseEntity<String> handleCpfNotFound(CpfNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> handleIdNotFound(IdNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> dataIntegrityViolationException(DataIntegrityViolationException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CPF already exists.");
	}
}
