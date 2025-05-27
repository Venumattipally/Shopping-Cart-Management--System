package com.shoppingcart.managementsystemn.exceptioHandler;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public  ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,  WebRequest request)  {
		
		String message =  ex.getBindingResult().getFieldError().getDefaultMessage();
		ErrorResponse errorResponse =  new ErrorResponse(LocalDateTime.now(), 
				HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()
				,message , request.getContextPath());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		
		
	}

}
