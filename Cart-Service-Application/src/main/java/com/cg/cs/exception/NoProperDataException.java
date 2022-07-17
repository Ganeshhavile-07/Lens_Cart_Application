package com.cg.cs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoProperDataException extends Exception {

	public NoProperDataException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
