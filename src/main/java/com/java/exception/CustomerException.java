package com.java.exception;

/**
 * @author Dhana
 * Customer API Exception class
 *
 */
public class CustomerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8160407685123944565L;
	
	public CustomerException(String message) {
		super(message);
	}
	
	public CustomerException(String message,Throwable cause) {
		super(message,cause);
	}

	
	
}
