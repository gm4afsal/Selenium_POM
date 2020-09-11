package com.mindtree.automation201.exceptions;

public class ButtonNotEnabledException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public ButtonNotEnabledException(String s) {
		message = s;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;

	}
}
