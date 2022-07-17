package com.cg.jwt.exception;

@SuppressWarnings("serial")
public class CartNotFoundException extends Exception {
	public CartNotFoundException(String s)
	{
		super(s);
	}
}
