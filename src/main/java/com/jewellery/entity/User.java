package com.jewellery.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;


@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity(name = "Users")
@Table(name = "users", uniqueConstraints = @UniqueConstraint(name = "username_unique", columnNames = "username"))
public class User {
	@Id
	@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
	@GeneratedValue(strategy = IDENTITY, generator = "user_sequence")
	@Column(name = "id", updatable = false)
	private Integer id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

//	@Email(message = "Email must be xxxx@xxx.xxx")
//	@NotBlank(message = "Email is required")
	private String email;

	private String phoneNumber;

	private String address;

	@Transient
	private String confirmPassword;

//	@Pattern(regexp = "^[A-Za-z0-9]{4,12}$", message = "Username must be alpbabets and numbers only with minimum length 4.")
//	@NotBlank(message = "User name is required")
	@Column(name = "username", nullable = false)
	private String username;

	@NotNull(message = "Role is required")
	@Column(name = "role", nullable = false)
	private String Role;

//	@NotEmpty(message = "Password can not be empty")
//	@Size(min = 8, max = 12, message = "Password must be between 8 and 12 characters long")
	@ToString.Exclude
	@Column(name = "password", nullable = false, columnDefinition = "text")
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
