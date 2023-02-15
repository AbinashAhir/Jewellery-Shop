package com.jewellery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

/*
 * this class is use to give login response using variable user name ,access
 * token and message
 */

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LoginResponse {

	private String username;
	private String accessToken;
	private String message;
	
	public LoginResponse(String message) {
		this.message=message;
	}
	
}

	

	
	
