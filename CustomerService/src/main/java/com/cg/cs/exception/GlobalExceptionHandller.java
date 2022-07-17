package com.cg.cs.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandller {
    
	  @ExceptionHandler(value =CustomerNotFoundException.class)
	  
	      public ResponseEntity<Map<String, Object>> handleGenericNotFoundException(CustomerNotFoundException e) {
	  
	          Map error = new HashMap<>();
	 
	          error.put("time",LocalDateTime.now());
	          //error.put("exception", );
	          error.put("msg", e.getMessage());
	          error.put("states", HttpStatus.NOT_FOUND);
	  
	         
	  
	        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	  
	      } 
	  @ExceptionHandler(value =Exception.class)
	  
      public ResponseEntity<Map<String, Object>> handleException(Exception e) {
  
          Map error = new HashMap<>();
 
          error.put("time",LocalDateTime.now());
          //error.put("exception", );
          error.put("msg", e.getMessage());
          error.put("states", HttpStatus.BAD_REQUEST);
  
         
  
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  
      } 
}
