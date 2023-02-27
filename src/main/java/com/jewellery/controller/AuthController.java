package com.jewellery.controller;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jewellery.config.JwtUtils;
import com.jewellery.entity.LoginRequest;
import com.jewellery.entity.LoginResponse;

import com.jewellery.exception.BadCredentialsException;
import com.jewellery.serviceImpl.JpaUserDetailsService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	Logger log = org.slf4j.LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JpaUserDetailsService userDetailsService;

	@Autowired
	private JwtUtils jwtUtils;

	// below code is for security login and also handle the exception
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest request, HttpServletResponse response)
			throws BadCredentialsException {
		
		log.debug("Authenticating user: {}", request.getUsername());


		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
					request.getPassword(), new ArrayList<>()));
			final UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
			if (user != null) {
				String jwt = jwtUtils.generateToken(user);
				Cookie cookie = new Cookie("jwt", jwt);
				cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
//                cookie.setSecure(true);
				cookie.setHttpOnly(true);
				cookie.setPath("/"); // Global
				response.addCookie(cookie);
				return ResponseEntity.ok(new LoginResponse(request.getUsername(), jwt, "Login Successful."));

			} else {
				throw new BadCredentialsException();

			}
		} catch (Exception e) {
			log.error("Authentication failed for user: {}", request.getUsername(), e);
			System.out.println(e);
			LoginResponse responses = new LoginResponse("Your credentials are incorrect.");
			responses.setUsername(request.getUsername());
			return new ResponseEntity<>(responses, HttpStatus.UNAUTHORIZED);
		}
	}

}
