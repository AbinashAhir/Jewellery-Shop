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

/*
 * this class is use for adding,updating and deleting the vendor and also there
 * is view bill and view feedback
 */
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private UserService userService;

	// Below method is use for update the vendor
	@PostMapping("/addVendor")
	public String addVendor(@RequestBody User user) {

		userService.addVendor(user);
		return "Vendor Added Successfully";
	}

	// Below method is use for update the vendor
	@PutMapping("/updateVendor")
	public User updateVendor(@RequestBody User user) {
		return adminService.updateVendor(user);
	}

	// Below method is use for delete the vendor
	@DeleteMapping("/deleteVendor/{userId}")
	public String deleteVender(@PathVariable("userId") Integer id) {
		return adminService.deleteVendor(id);
	}

	// Below list is use for viewing feedback
	@GetMapping("/viewFeedback")
	public List<Feedback> getAllFeedback() {
		return adminService.getAllFeedback();
	}

	// Below list is use for view bill
	@GetMapping("/viewBill")
	public List<Billing> getAllBill() {
		return adminService.getAllBill();
	}

}
