package com.jewellery.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jewellery.entity.Billing;
import com.jewellery.entity.Feedback;
import com.jewellery.entity.User;
import com.jewellery.exception.UserAlreadyExistException;

public interface AdminService {

	public String addVendor(User user) throws UserAlreadyExistException;

	public String updateVendor(User user);

	public String deleteVendor(Integer userId);

	public List<Billing> getAllBill();

	public List<Feedback> getAllFeedback();
}