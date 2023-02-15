package com.jewellery.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.jewellery.entity.BadCredentialResponse;
import com.jewellery.entity.User;
import com.jewellery.exception.UserAlreadyExistException;
import com.jewellery.repository.UserRepository;
import com.jewellery.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	// Below code is for register the user,vendor and customer
	@PostMapping("/register")
<<<<<<< HEAD
	public ResponseEntity<?> register(@Valid @RequestBody User user, BindingResult result)
			throws TransactionSystemException, UserAlreadyExistException {
//		if (!user.getPassword().equals(user.getConfirmPassword())) {
//			result.rejectValue("confirmPassword", "error.confirmPassword",
//					"Password and confirm password do not match.");
//			// return the registration form view with validation errors
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//					.body(new BadCredentialResponse("Password and Confirm Password are not matching!"));
//		}else if (!(user.getPassword().length() < 8 && user.getPassword().length() > 12)) {
//			result.rejectValue("Password", "error.Password", "Password length must between 8 to 12.");
//			// return the registration form view with validation errors
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//					.body(new BadCredentialResponse("Password must be of min 8 max 12 chars."));
//		}
		
		if (result.hasErrors()) {
	        // create a list of error messages from the BindingResult object
	        List<String> errorMessages = result.getAllErrors()
	                .stream()
	                .map(error -> error.getDefaultMessage())
	                .collect(Collectors.toList());

	        // return a custom error message with a BAD REQUEST status code
	        return ResponseEntity.badRequest().body(new BadCredentialResponse("Invalid request payload", errorMessages));
	    }
		else if (!user.getPassword().equals(user.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "error.confirmPassword",
					"Password and confirm password do not match.");
			List<String> errorMessages = result.getAllErrors()
	                .stream()
	                .map(error -> error.getDefaultMessage())
	                .collect(Collectors.toList());
			// return the registration form view with validation errors
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new BadCredentialResponse("Please check your password and confirm password again.",errorMessages));
		}

		else {
			return ResponseEntity.ok(userService.addUser(user));
		}

=======
	public ResponseEntity<User> register(@Valid @RequestBody User user)
			throws TransactionSystemException, UserAlreadyExistException {
		return ResponseEntity.ok(userService.addUser(user));
>>>>>>> 33adb19e43f780e8e5832ddce25c133679b05f60
	}

}
