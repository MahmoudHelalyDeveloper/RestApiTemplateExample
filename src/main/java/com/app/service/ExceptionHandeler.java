package com.app.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandeler  extends Exception {

	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ExceptionHandeler(String message) {
		super();
		this.message = message;
	}

	public ExceptionHandeler() {
		super();
	} 
	
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<String> handelException(Exception ex){
		
		
		return new ResponseEntity(ex.getMessage(),HttpStatus.BAD_GATEWAY);
	}  
	
	
	
	
	
	
}
