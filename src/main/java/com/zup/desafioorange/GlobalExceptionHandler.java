package com.zup.desafioorange;

import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zup.desafioorange.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	public GlobalExceptionHandler() {
	}
	
	@ExceptionHandler(JdbcSQLIntegrityConstraintViolationException.class)
	public ResponseEntity<Object> handleJdbcSQLIntegrityConstraintViolationException() {
		return new ResponseEntity<Object>("User already cadastred", HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException() {	
		return new ResponseEntity<Object>("User not found for that email", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(){
		return new ResponseEntity<Object> ("Check the fields! Some are invalids ", HttpStatus.BAD_REQUEST);
	}
	
}
