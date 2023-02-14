package com.jewellery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping("/register")
	public ResponseEntity<User> register(@Valid @RequestBody User user) throws TransactionSystemException, UserAlreadyExistException {
		return ResponseEntity.ok(userService.addUser(user));
	}

}
