package com.jewellery.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.jewellery.entity.User;
import com.jewellery.exception.UserAlreadyExistException;
import com.jewellery.repository.UserRepository;
import com.jewellery.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private final UserRepository usersRepository;

	/*
	 * this method is use to see whether username is present or not if username
	 * already present then it will throw an exception with message user already
	 * exists
	 */
	@Override
	public User addUser(User user) throws TransactionSystemException, UserAlreadyExistException {

		if (usersRepository.findByUsername(user.getUsername()).isPresent()) {
			throw new UserAlreadyExistException("User already exists");
		} else {
			String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
			String encryptedcPassword = new BCryptPasswordEncoder().encode(user.getConfirmPassword());
			user.setPassword(encryptedPassword);
			user.setConfirmPassword(encryptedcPassword);
			return usersRepository.save(user);
		}

//		String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
//		user.setPassword(encryptedPassword);
//		return usersRepository.save(user);

	}

	/*
	 * this method is use for encrypt password and pass the message
	 * "Vendor added successfully"
	 */
	@Override
	public String addVendor(User user) {
		String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword(encryptedPassword);
		usersRepository.save(user);
		return "Vendor added successfully";
	}

	/*
	 * this method is use update the encrypt password
	 */
	@Override
	public User updateVendor(User user) {
		String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword(encryptedPassword);
		return usersRepository.save(user);
	}
}
