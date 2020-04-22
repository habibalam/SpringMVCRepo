package com.app.exception;

public class UserBlockException extends Exception {
    
	// create user object without error description
	public UserBlockException() {
		
	}
	
	// create user object with error description
	public UserBlockException(String errDesc) {
		super(errDesc);
	}
	
}
