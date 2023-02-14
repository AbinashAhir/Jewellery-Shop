package com.jewellery.advice;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//import com.jewellery.exception.DuplicateItemException;
import com.jewellery.exception.ProductNotFoundException;
import com.jewellery.exception.UserAlreadyExistException;
import com.jewellery.exception.UserNotFoundException;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.links.Link;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.responses.ApiResponses;

@RestControllerAdvice
public class JewelleryExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleBadRequestException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new LinkedHashMap<>();

		ex.getFieldErrors().stream().forEach(fieldError -> {
			errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		});
		ResponseEntity<Map<String, String>> response = new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		return response;
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<String> handleAccessDeniedException(AccessDeniedException se) {
		ResponseEntity<String> response = new ResponseEntity<>("Access Denied", HttpStatus.UNAUTHORIZED);
		return response;
	}

	
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<String> handleUserAlreadyExistException(UserAlreadyExistException se) {
		ResponseEntity<String> response = new ResponseEntity<>(se.getMessage(), HttpStatus.BAD_REQUEST);
		return response;
	}
	
//	@ExceptionHandler(DuplicateItemException.class)
//	public ResponseEntity<String> handleDuplicateItemException(DuplicateItemException se) {
//		ResponseEntity<String> response = new ResponseEntity<>(se.getMessage(), HttpStatus.BAD_REQUEST);
//		return response;
//	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException pnf) {
		ResponseEntity<String> response = new ResponseEntity<>(pnf.getMessage(), HttpStatus.NOT_FOUND);
		return response;
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> handleProductNotFoundException(DataIntegrityViolationException ex) {
		ResponseEntity<String> response = new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
		return response;
	}

//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//
//	public ApiResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
//
//		Map<String, String> errors = new HashMap<>();
//
//		ex.getBindingResult().getFieldErrors().forEach(error -> {
//
//			if (errors.containsKey(error.getField())) {
//
//				errors.put(error.getField(),
//						String.format("%s, %s", errors.get(error.getField()), error.getDefaultMessage()));
//
//			} else {
//
//				errors.put(error.getField(), error.getDefaultMessage());
//
//			}
//
//		}
//
//		);
//
//		return new ApiResponse();
//	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleInternalServerException(Exception ex) {
		ResponseEntity<String> response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return response;

	}
}
