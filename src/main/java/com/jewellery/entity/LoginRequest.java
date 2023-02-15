package com.jewellery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * this class is use to take request for login with variable user name and
 * password
 */

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {
	private String username;
	private String password;
}
