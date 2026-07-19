package com.nikhil.inventra.exceptions_handlng;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nikhil.inventra.dto.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
		
	
	@ExceptionHandler(CustomExceptions.class)
	public ResponseEntity<ApiResponse> handleCustomExceptions(CustomExceptions ex){
	
		ApiResponse response = new ApiResponse(
					false, ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex){
	
		Map<String , String> errors = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});
		
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
