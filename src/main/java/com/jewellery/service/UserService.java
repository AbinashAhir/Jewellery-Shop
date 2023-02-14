package com.jewellery.service;

import java.util.Optional;

import org.springframework.transaction.TransactionSystemException;

import com.jewellery.entity.User;
import com.jewellery.exception.UserAlreadyExistException;

public interface UserService {
	public User addUser(User user) throws TransactionSystemException, UserAlreadyExistException;

	public String addVendor(User user);

	public User updateVendor(User user);
}
