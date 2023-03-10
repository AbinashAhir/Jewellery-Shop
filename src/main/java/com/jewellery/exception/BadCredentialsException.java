package com.jewellery.exception;

public class BadCredentialsException extends Exception {

	public BadCredentialsException() {
		super();
	}

	public BadCredentialsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BadCredentialsException(String message, Throwable cause) {
		super(message, cause);
	}

	public BadCredentialsException(String message) {
		super(message);
	}

	public BadCredentialsException(Throwable cause) {
		super(cause);
	}

}
