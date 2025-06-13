package com.example.demo.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.ServiceImpl.UserAlreadyExistsException;

@ControllerAdvice
public class GlogablExceptionHandle {
	
	
	 @ExceptionHandler(UserAlreadyExistsException.class)
	    public ResponseEntity<String> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}