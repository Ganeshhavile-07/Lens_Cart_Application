package com.cg.gs.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

//import com.cg.gs.entity.MyErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandller {
    
	  @ExceptionHandler(value =GlassNotFoundException.class)
	  
	      public ResponseEntity<Map<String, Object>> handleGenericNotFoundException(GlassNotFoundException e) {
	  
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
//	  @ExceptionHandler({RoleNotFoundException.class})
//		public ResponseEntity<MyErrorResponse> handleProductNotFound(RoleNotFoundException ex){
//					MyErrorResponse error=new MyErrorResponse();
//			error.setTimestamp(LocalDateTime.now());
//			error.setStatus(HttpStatus.NOT_FOUND);
//			error.setMessage(ex.getMessage());
//			error.setReason("id doesn't exist....");
//			return new ResponseEntity<MyErrorResponse>(error,HttpStatus.NOT_FOUND);
//		}
		
		//this method is responsible for handling all the internal server errors from class cartnptfoundexception
//		@ExceptionHandler({GlassNotFoundException.class})
//		public ResponseEntity<MyErrorResponse> handleCartIdNotFound(GlassNotFoundException cart){
//					MyErrorResponse error=new MyErrorResponse();
//			error.setTimestamp(LocalDateTime.now());
//			error.setStatus(HttpStatus.NOT_FOUND);
//			error.setMessage(cart.getMessage());
//			error.setReason("id doesn't exist....");
//			return new ResponseEntity<MyErrorResponse>(error,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
		

		//@ExceptionHandler({MethodArgumentTypeMismatchException.class})
//		public ResponseEntity<MyErrorResponse> handleBadRequest(MethodArgumentTypeMismatchException ex){
//					MyErrorResponse error=new MyErrorResponse();
//			error.setTimestamp(LocalDateTime.now());
//			error.setStatus(HttpStatus.BAD_REQUEST);
//			error.setMessage(ex.getMessage());
//			error.setReason("Wrong url/method typed ....");
//			return new ResponseEntity<MyErrorResponse>(error,HttpStatus.BAD_REQUEST);
//		}
//
//
//		@ExceptionHandler({HttpRequestMethodNotSupportedException.class})
//		public ResponseEntity<MyErrorResponse> handleMethodNotSupportException(HttpRequestMethodNotSupportedException ex){
//					MyErrorResponse error=new MyErrorResponse();
//			error.setTimestamp(LocalDateTime.now());
//			error.setStatus(HttpStatus.METHOD_NOT_ALLOWED);
//			error.setMessage(ex.getMessage());
//			error.setReason("Wrong method selected....");
//			return new ResponseEntity<MyErrorResponse>(error,HttpStatus.METHOD_NOT_ALLOWED);
//		}

		
}
