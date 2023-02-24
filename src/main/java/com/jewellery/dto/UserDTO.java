package com.jewellery.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {

	private Integer id;

	@NotBlank(message = "FirstName is required")
	private String firstName;
	@NotBlank(message = "LastName is required")
	private String lastName;

	@Email(message = "Email must be xxxx@xxx.xxx")
	@NotBlank(message = "Email is required")
	private String email;

	// For Indian Numbers only.
	@NotNull(message = "Phone Number is required")
	@Pattern(regexp = "^[6-9]\\d{9}$")
	private String phoneNumber;

	@NotBlank(message = "Address is required")
	private String address;

	@NotBlank(message = "Confirm Password is required")
	private String confirmPassword;

	@Pattern(regexp = "^[A-Za-z0-9]{4,12}$", message = "Username must be alpbabets and numbers only with minimum length 4.")
	@NotBlank(message = "User name is required")
	private String username;

	@Pattern(regexp = "^[A-Z_]*$", message = "Role must be Uppercase alphabets only with prefix ROLE_")
	@NotBlank(message = "Role is required")
	private String Role;

	@Pattern(regexp = "^[A-Za-z0-9]{8,12}$", message = "Password must be alpbabets and numbers only with minimum length 8 and maximum 12.")
	@NotEmpty(message = "Password can not be empty")
	@Size(min = 8, max = 12, message = "Password must be between 8 and 12 characters long")
	private String password;

}
