package com.jewellery.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import com.jewellery.entity.Billing;
import com.jewellery.entity.Feedback;
import com.jewellery.entity.Product;
import com.jewellery.entity.User;
import com.jewellery.exception.UserAlreadyExistException;
import com.jewellery.repository.BillingRepository;
import com.jewellery.repository.FeedbackRepository;
import com.jewellery.repository.ProductRepository;
import com.jewellery.repository.UserRepository;
import com.jewellery.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {


	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private BillingRepository billingRepository;

	@Autowired
	private FeedbackRepository feedbackRepository;

	// this method is use for adding the vendor

	@Override
	public String addVendor(User user) throws UserAlreadyExistException {

		if (userRepository.findByUsername(user.getUsername()).isPresent()) {
			throw new UserAlreadyExistException("User already exists");
		} else {
			String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
			String encryptedcPassword = new BCryptPasswordEncoder().encode(user.getConfirmPassword());
			user.setPassword(encryptedPassword);
			user.setConfirmPassword(encryptedcPassword);
			userRepository.save(user);
			return "Vendor added successfully.";
		}
	}

	// this method is use for updating the vendor
	@Override
	public String updateVendor(User user) {
		User users = userRepository.findById(user.getId()).get();

		if (Objects.nonNull(user.getId())) {

			users.setId(user.getId());
		}

		if (Objects.nonNull(user.getFirstName()) && !"".equalsIgnoreCase(user.getFirstName())) {
			users.setFirstName(user.getFirstName());
		}

		if (Objects.nonNull(user.getLastName()) && !"".equalsIgnoreCase(user.getLastName())) {
			users.setLastName(user.getLastName());
		}

		if (Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) {
			users.setEmail(user.getEmail());
		}

		if (Objects.nonNull(user.getPassword()) && !"".equalsIgnoreCase(user.getPassword())) {

			users.setPassword(passwordEncoder.encode(user.getPassword()));
		}

		if (Objects.nonNull(user.getPhoneNumber())) {
			users.setPhoneNumber(user.getPhoneNumber());
		}

		if (Objects.nonNull(user.getAddress()) && !"".equalsIgnoreCase(user.getAddress())) {
			users.setAddress(user.getAddress());
		}

		if (Objects.nonNull(user.getRole())) {
			users.setRole(user.getRole());
		}

		userRepository.save(users);
		return "Vendor updated sucessfully.";
	}

	// this method is use to delete vendor
	@Override
	public String deleteVendor(Integer userId) {
		userRepository.deleteById(userId);

		return "Vendor deleted successfully";

	}


	


	/*
	 * below code is use to create a list of billing type to store all bill by
	 * fethching all bill
	 */


	@Override
	public List<Billing> getAllBill() {
		return billingRepository.findAll();
	}


	/*
	 * below code is use to create a list of Feedback type to store all Feedback by
	 * fetching all feedback
	 */


	// Add it.
	@Override
	public List<Feedback> getAllFeedback() {
		return feedbackRepository.findAll();
	}


}
