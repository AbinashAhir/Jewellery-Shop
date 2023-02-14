package com.jewellery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

//this class is use to take request for login
public class LoginRequest {
	private String username;
	private String password;
}
