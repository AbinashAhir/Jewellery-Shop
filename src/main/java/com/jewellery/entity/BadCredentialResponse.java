package com.jewellery.entity;

import java.util.List;

public class BadCredentialResponse {
	private String message;
	private List<String> errors;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	public BadCredentialResponse(String message, List<String> errors) {
		super();
		this.message = message;
		this.errors = errors;
	}
	public BadCredentialResponse(String string) {
		this.message= string;
	}

	
}
