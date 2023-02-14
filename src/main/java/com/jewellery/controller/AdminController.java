package com.jewellery.controller;


import com.jewellery.entity.Billing;
import com.jewellery.entity.Feedback;
import com.jewellery.entity.User;

import com.jewellery.service.AdminService;
import com.jewellery.service.UserService;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {


	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;

	
	@PostMapping("/addVendor")
	public String addVendor(@RequestBody User user){

		userService.addVendor(user);
		return "Vendor Added Successfully";
	}

	@PutMapping("/updateVendor")
	public User updateVendor(@RequestBody User user) {
		return adminService.updateVendor(user);
	}

	@DeleteMapping("/deleteVendor/{userId}")
	public String deleteVender(@PathVariable("userId") Integer id) {
		return adminService.deleteVendor(id);
	}
	
	@GetMapping("/viewFeedback")
	public List<Feedback> getAllFeedback(){
		return adminService.getAllFeedback();
	}

	@GetMapping("/viewBill")
	public List<Billing> getAllBill() {
		return adminService.getAllBill();
	}

}
