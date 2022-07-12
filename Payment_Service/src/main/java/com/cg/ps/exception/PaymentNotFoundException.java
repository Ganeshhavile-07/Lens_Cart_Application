package com.cg.ps.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =HttpStatus.NOT_FOUND)
public class PaymentNotFoundException extends Exception  {

	public PaymentNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
