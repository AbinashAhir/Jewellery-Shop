package com.jewellery.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersRequest {

	private String first_name;

	private String last_name;

	private String email;

	private String username;

	private String password;

	private String confirmPassword;

	private String phoneNumber;

	private String address;

	private String roles;
}
