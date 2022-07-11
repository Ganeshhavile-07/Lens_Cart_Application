package com.cg.lenscart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FrameNotFoundException  extends Exception{

	public FrameNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
  
}
