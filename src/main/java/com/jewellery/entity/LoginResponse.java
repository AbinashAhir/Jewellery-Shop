package com.jewellery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

//this class is use to give login response like username ,accesstoken and message
public class LoginResponse {

	private String username;
	private String accessToken;
	private String message;

}
