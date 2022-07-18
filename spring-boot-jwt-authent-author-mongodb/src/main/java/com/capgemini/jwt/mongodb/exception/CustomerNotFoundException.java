package com.capgemini.jwt.mongodb.exception;

@SuppressWarnings("serial")
public class CustomerNotFoundException extends Exception {
	public CustomerNotFoundException(String s)
	{
		super(s);
	}
}
