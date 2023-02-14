package com.jewellery.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity(name = "Users")
@Table(name = "users", uniqueConstraints = @UniqueConstraint(name = "username_unique", columnNames = "username"))
public class User {
	@Id
	@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
	@GeneratedValue(strategy = SEQUENCE, generator = "user_sequence")
	@Column(name = "id", updatable = false)
	private Integer id;

//	@NotBlank(message = "First name is required")
	@Column(name = "first_name", nullable = false)
	private String firstName;
//	
//	@NotBlank(message = "Last name is required")
	@Column(name = "last_name")
	private String lastName;

//	@Email(message = "Email must be xxxx@xxx.xxx")
//	@NotBlank(message = "Email is required")
	private String email;

//	@NotNull(message = "Phone Number is required")
	private Long phoneNumber;

//	@NotNull(message = "Address is required")
	private String address;

//	@NotEmpty(message = "Confirm Password can not be empty")
//	@Size(min = 8, max = 12, message = "Confirm Password must match the password")
	private String confirmPassword;

	public String getUsername() {
		return username;
	}

	// this method is use for setting username
	public void setUsername(String username) {
		this.username = username;
	}

	// this method is use for fetching password
	public String getPassword() {
		return password;
	}

	// this method is use for setting password
	public void setPassword(String password) {
		this.password = password;
	}

	// this method is use for setting ID
	public void setId(Integer id) {
		this.id = id;
	}

	// this method is use for fetching email
	public String getEmail() {
		return email;
	}

	// this method is use for setting email
	public void setEmail(String email) {
		this.email = email;
	}

	// this method is use for fetching id
	public Integer getId() {
		return id;
	}

	// this method is use for fetching phone number
	public Long getPhoneNumber() {
		return phoneNumber;
	}

	// this method is use for setting phone number
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// this method is use for fetching Address
	public String getAddress() {
		return address;
	}

	// this method is use for setting Address
	public void setAddress(String address) {
		this.address = address;
	}

	// this method is use for fetching first name
	public String getFirstName() {
		return firstName;
	}

	// this method is use for setting first name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// this method is use for fetching Last Name
	public String getLastName() {
		return lastName;
	}

	// this method is use for setting last name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// this method is use for fetching Role
	public String getRole() {
		return Role;
	}

	// this method is use for setting Role
	public void setRole(String role) {
		Role = role;
	}

	// this method is use for fetching confirm password
	public String getConfirmPassword() {
		return confirmPassword;
	}

	// this method is use for setting confirm password
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

//	@NotBlank(message = "User name is required")
	@Column(name = "username", nullable = false)
	private String username;

//	@NotNull(message = "Role is required")
	@Column(name = "role", nullable = false)
	private String Role;

//	@NotEmpty(message = "Password can not be empty")
//	@Size(min = 8, max = 12, message = "Password must be between 8 and 12 characters long")
	@ToString.Exclude
	@Column(name = "password", nullable = false, columnDefinition = "text")
	private String password;

}
