package com.cg.jwt.exception;

@SuppressWarnings("serial")
public class RecordAlreadyExistsException extends Exception{
	
	public RecordAlreadyExistsException(String ss)
	{
		super(ss);
	}

}
