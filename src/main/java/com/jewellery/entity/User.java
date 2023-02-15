//package com.jewellery.entity;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Pattern;
//import jakarta.validation.constraints.Size;
//import lombok.*;
//
//import static jakarta.persistence.GenerationType.SEQUENCE;
//
//@ToString
//@RequiredArgsConstructor
//@EqualsAndHashCode
//@Entity(name = "Users")
//@Table(name = "users", uniqueConstraints = @UniqueConstraint(name = "username_unique", columnNames = "username"))
//public class User {
//	@Id
//	@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
//	@GeneratedValue(strategy = SEQUENCE, generator = "user_sequence")
//	@Column(name = "id", updatable = false)
//	private Integer id;
//
//	@NotBlank(message = "First name is required")
//	@Column(name = "first_name", nullable = false)
//	private String firstName;
//
//	@NotBlank(message = "Last name is required")
//	@Column(name = "last_name")
//	private String lastName;
//
//	@Email(message = "Email must be xxxx@xxx.xxx")
//	@NotBlank(message = "Email is required")
//	private String email;
//
//	// For Indian Numbers only.
//	@NotNull(message = "Phone Number is required")
//	@Pattern(regexp = "^[6-9]\\d{9}$", message="Indian Numbers Only(Starts with 6-9).")
//	private String phoneNumber;
//
//	@NotNull(message = "Address is required")
//	private String address;
//
//	@NotEmpty(message = "Confirm Password can not be empty")
//	@Size(min = 8, max = 12, message = "Confirm Password must match the password")
//	@Transient
//	private String confirmPassword;
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public String getPhoneNumber() {
//		return phoneNumber;
//	}
//
//	public void setPhoneNumber(String phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getRole() {
//		return Role;
//	}
//
//	public void setRole(String role) {
//		Role = role;
//	}
//
//	public String getConfirmPassword() {
//		return confirmPassword;
//	}
//
//	public void setConfirmPassword(String confirmPassword) {
//		this.confirmPassword = confirmPassword;
//	}
//
//	@NotBlank(message = "User name is required")
//	@Column(name = "username", nullable = false)
//	private String username;
//
//	@NotNull(message = "Role is required")
//	@Column(name = "role", nullable = false)
//	private String Role;
//
//	@Pattern(regexp = "^[A-Za-z0-9]{8,12}$", message = "Password must be alpbabets and numbers only.")
//	@NotEmpty(message = "Password can not be empty")
//	@Size(min = 8, max = 12, message = "Password must be between 8 and 12 characters long")
//	@ToString.Exclude
//	@Column(name = "password", nullable = false, columnDefinition = "text")
//	private String password;
//
//}




//-------------------------------------------------------------------------------------------------------------------------------------------------------------








//package com.jewellery.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//
//import java.util.Collection;
//import java.util.List;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User.UserBuilder;
//import org.springframework.security.core.userdetails.UserDetails;
//
//@Data
//@Builder
//@NoArgsConstructor
//@Getter
//@Setter
//@AllArgsConstructor
//@Entity
//@Table(name = "_user")
//public class User implements UserDetails {
//
//	private static final long serialVersionUID = 1L;
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	private Integer id;
//	
//	@NotBlank(message = "First name is required")
//	private String firstname;
//	
//	@NotBlank(message = "Last name is required")
//	private String lastname;
//	
//	@Email(message = "Email must be xxxx@xxx.xxx")
//	@NotBlank(message = "Email is required")
//	private String email;
//	
//	@NotEmpty(message = "Password can not be empty")
//	@Size(min = 8, max = 12, message = "Password must be between 8 and 12 characters long")
//	private String password;
//	
//	@NotNull(message = "Phone Number is required")
//	private long phoneNumber;
//	
//	@NotNull(message = "Address is required")
//	private String address;
//
//	@Enumerated(EnumType.STRING)
//	@NotNull(message = "Role is required")
//	private Role role;
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getFirstname() {
//		return firstname;
//	}
//
//	public void setFirstname(String firstname) {
//		this.firstname = firstname;
//	}
//
//	public String getLastname() {
//		return lastname;
//	}
//
//	public void setLastname(String lastname) {
//		this.lastname = lastname;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public long getPhoneNumber() {
//		return phoneNumber;
//	}
//
//	public void setPhoneNumber(long phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}
//
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return List.of(new SimpleGrantedAuthority(role.name()));
//	}
//
//	@Override
//	public String getPassword() {
//		return password;
//	}
//
//	@Override
//	public String getUsername() {
//		return email;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//
//}

package com.jewellery.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

	@Email(message = "Email must be xxxx@xxx.xxx")
	@NotBlank(message = "Email is required")
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

	@Pattern(regexp = "^[A-Za-z0-9]{4,12}$", message = "Username must be alpbabets and numbers only with minimum length 4.")
	@NotBlank(message = "User name is required")
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
