package com.jewellery.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -567694469232019176L;

	private String errorMessage;

}
