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

//	@NotBlank(message = "First name is required")
	private String first_name;

//	@NotBlank(message = "Last name is required")
	private String last_name;

//	@Email(message = "Email must be xxxx@xxx.xxx")
//	@NotBlank(message = "Email is required")
	private String email;

//	@NotBlank(message = "User name is required")
	private String username;

//	@NotEmpty(message = "Password can not be empty")
//	@Size(min = 8, max = 12, message = "Password must be between 8 and 12 characters long")
	private String password;

//	@NotEmpty(message = "Confirm Password can not be empty")
//	@Size(min = 8, max = 12, message = "Confirm Password must match the password")
	private String confirmPassword;

//	@NotNull(message = "Phone Number is required")
	private String phoneNumber;

//	@NotNull(message = "Address is required")
	private String address;

//	@NotNull(message = "Role is required")
	private String roles;
}
