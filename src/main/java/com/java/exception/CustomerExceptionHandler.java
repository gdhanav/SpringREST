package com.java.exception;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Dhana
 * Customer API exception class to handle all exceptions.
 * We can configure/map any number exceptions with a method for an action.
 */
@ControllerAdvice
public class CustomerExceptionHandler {
	
	@ExceptionHandler(value={CustomerException.class})
	public ResponseEntity<String> handleException(HttpRequest request,Exception ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.FORBIDDEN);
	}

}
