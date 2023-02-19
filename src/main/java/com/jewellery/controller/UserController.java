package com.jewellery.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.jewellery.converter.UserConverter;
import com.jewellery.dto.UserDTO;
import com.jewellery.entity.BadCredentialResponse;
import com.jewellery.entity.LoginResponse;
import com.jewellery.entity.RegisterResponse;
import com.jewellery.entity.User;
import com.jewellery.exception.UserAlreadyExistException;
import com.jewellery.repository.UserRepository;
import com.jewellery.service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConverter converter;

	// Below code is for register the user,vendor and customer
//	@PostMapping("/register")
//
//	public ResponseEntity<?> register(@Valid @RequestBody User user, BindingResult result)
//			throws TransactionSystemException, UserAlreadyExistException {
//
//		if (result.hasErrors()) {
//			// create a list of error messages from the BindingResult object
//			List<String> errorMessages = result.getAllErrors().stream().map(error -> error.getDefaultMessage())
//					.collect(Collectors.toList());
//
//			// return a custom error message with a BAD REQUEST status code
//			return ResponseEntity.badRequest()
//					.body(new BadCredentialResponse("Invalid request payload", errorMessages));
//		} else if (user.getPassword().length() < 8 || user.getPassword().length() > 12) {
//			result.rejectValue("confirmPassword", "error.confirmPassword",
//					"Password length is less than 8 or more than 12.");
//			List<String> errorMessages = result.getAllErrors().stream().map(error -> error.getDefaultMessage())
//					.collect(Collectors.toList());
//			// return the registration form view with validation errors
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadCredentialResponse(
//					"Please check your password length is less than 8 or more than 12.", errorMessages));
//		}
//
//		else if (!user.getPassword().equals(user.getConfirmPassword())) {
//			result.rejectValue("confirmPassword", "error.confirmPassword",
//					"Password and confirm password do not match.");
//			List<String> errorMessages = result.getAllErrors().stream().map(error -> error.getDefaultMessage())
//					.collect(Collectors.toList());
//			// return the registration form view with validation errors
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
//					new BadCredentialResponse("Please check your password and confirm password again.", errorMessages));
//		}
//
//		else {
//			userService.addUser(user);
//			return ResponseEntity.ok(new RegisterResponse("Registration Successful.", user.getUsername()));
//		}
//
//	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody UserDTO dto, BindingResult result)
			throws TransactionSystemException, UserAlreadyExistException {

		if (result.hasErrors()) {
			// create a list of error messages from the BindingResult object
			List<String> errorMessages = result.getAllErrors().stream().map(error -> error.getDefaultMessage())
					.collect(Collectors.toList());

			// return a custom error message with a BAD REQUEST status code
			return ResponseEntity.badRequest()
					.body(new BadCredentialResponse("Invalid request payload", errorMessages));
		} else if (!dto.getRole().startsWith("ROLE_")) {
			result.rejectValue("Role prefix", "error.role prefix", "Role must be start with ROLE_");
			List<String> errorMessages = result.getAllErrors().stream().map(error -> error.getDefaultMessage())
					.collect(Collectors.toList());
			// return the registration form view with validation errors
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new BadCredentialResponse("Please check your Role prefix again.", errorMessages));
		}

		else if (!dto.getPassword().equals(dto.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "error.confirmPassword",
					"Password and confirm password do not match.");
			List<String> errorMessages = result.getAllErrors().stream().map(error -> error.getDefaultMessage())
					.collect(Collectors.toList());
			// return the registration form view with validation errors
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					new BadCredentialResponse("Please check your password and confirm password again.", errorMessages));
		} else {
			User user = converter.dtoToEntity(dto);
			user = userService.addUser(user);
			return ResponseEntity.ok(new RegisterResponse("Registration Successful.", dto.getUsername()));
		}
	}

}
