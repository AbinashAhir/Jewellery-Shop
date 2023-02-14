package com.jewellery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

/*
 * this class is use to give login response using variable user name ,access
 * token and message
 */
public class LoginResponse {

	private String username;
	private String accessToken;
	private String message;

}
