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

	@Override
	public User addUser(User user) throws TransactionSystemException, UserAlreadyExistException {
		
		if(usersRepository.findByUsername(user.getUsername()).isPresent()) {
			throw new UserAlreadyExistException("User already exists");
		}
		else {
			String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
			user.setPassword(encryptedPassword);
			return usersRepository.save(user);
		}
		
		
//		String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
//		user.setPassword(encryptedPassword);
//		return usersRepository.save(user);
		
	}

	@Override
	public String addVendor(User user) {
		String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword(encryptedPassword);
		usersRepository.save(user);
		return "Vendor added successfully";
	}

	@Override
	public User updateVendor(User user) {
		String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword(encryptedPassword);
		return usersRepository.save(user);
	}
}
