package com.dowlath.rang.restful.restfulwebservice.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object>  handleAllExceptions(Exception ex, WebRequest request){
		
		ResponseException responseException = new ResponseException(new Date(),ex.getMessage(),request.getDescription(false));
				
		return new ResponseEntity(responseException,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object>  handleUserNotFoundExceptions(UserNotFoundException ex, WebRequest request){
		
		ResponseException responseException = new ResponseException(new Date(),ex.getMessage(),request.getDescription(false));
				
		return new ResponseEntity(responseException,HttpStatus.NOT_FOUND);
		
	}
	
	//@ExceptionHandler(UserNotFoundException.class)
	//public <MethodArugmentNotValidHttpHeaders> ResponseEntity<Object>  handleMethodArgumentNotValidExceptions(MethodArugmentNotValidHttpHeaders headers,HttpStatus status, WebRequest request){
		
		//ResponseException responseException = new ResponseException(new Date(),ex,request.g);
				
		//return new ResponseEntity(responseException,HttpStatus.NOT_FOUND);
		
	//}
	

}
