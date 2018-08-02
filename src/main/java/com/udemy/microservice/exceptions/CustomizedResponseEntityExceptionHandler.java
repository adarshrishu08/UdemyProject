package com.udemy.microservice.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse excetionResponse = new ExceptionResponse(ex.getMessage(), new Date(),
				request.getDescription(false));
		return new ResponseEntity<Object>(excetionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundExceptions(UserNotFoundException ex, WebRequest request) throws Exception {
		ExceptionResponse excetionResponse = new ExceptionResponse(ex.getMessage(), new Date(),
				request.getDescription(false));
		return new ResponseEntity<Object>(excetionResponse, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse excetionResponse = new ExceptionResponse("Validation Failed", new Date(),
				ex.getBindingResult().toString());
		return new ResponseEntity<Object>(excetionResponse, HttpStatus.BAD_REQUEST);
	}
}
