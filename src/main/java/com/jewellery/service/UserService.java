package com.jewellery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.TransactionSystemException;

import com.jewellery.entity.Billing;
import com.jewellery.entity.Feedback;
import com.jewellery.entity.User;
import com.jewellery.exception.UserAlreadyExistException;

public interface UserService {
	public User addUser(User user) throws TransactionSystemException, UserAlreadyExistException;

}
