package com.cg.sgs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SunGlassesNotFoundException extends Exception{

	public SunGlassesNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
