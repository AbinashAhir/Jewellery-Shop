package com.jewellery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class LoginResponse {

	private String username;
	private String accessToken;
	private String message;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LoginResponse(String username, String accessToken, String message) {
		super();
		this.username = username;
		this.accessToken = accessToken;
		this.message = message;
	}
	public LoginResponse( String message) {
		
		this.message = message;
	}


}
