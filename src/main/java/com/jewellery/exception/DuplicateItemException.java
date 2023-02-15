package com.jewellery.exception;

public class DuplicateItemException extends Exception {

	public DuplicateItemException() {
		super();

	}

	public DuplicateItemException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public DuplicateItemException(String message, Throwable cause) {
		super(message, cause);

	}

	public DuplicateItemException(String message) {
		super(message);

	}

	public DuplicateItemException(Throwable cause) {
		super(cause);

	}

}
