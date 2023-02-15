package com.jewellery.entity;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BadCredentialResponse {
	private String message;
	private List<String> errors;

	public BadCredentialResponse(String string) {
		this.message = string;
	}

	public BadCredentialResponse(String message, List<String> errors) {
		super();
		this.message = message;
		this.errors = errors;
	}

}
