package com.jewellery.controller;

import com.jewellery.entity.Billing;
import com.jewellery.entity.Feedback;
import com.jewellery.entity.User;
import com.jewellery.exception.UserAlreadyExistException;
import com.jewellery.service.AdminService;
import com.jewellery.service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Level;
import org.slf4j.Logger;
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

/*
 * this class is use for adding,updating and deleting the vendor and also there
 * is view bill and view feedback
 */

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	Logger log = org.slf4j.LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService;

	// Below method is use for update the vendor
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@PostMapping("/addVendor")
	public String addVendor(@RequestBody User user) throws UserAlreadyExistException {
		log.debug("Adding vendor: {}", user.getUsername());
		return adminService.addVendor(user);
	}

	// Below method is use for update the vendor
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@PutMapping("/updateVendor")
	public String updateVendor(@RequestBody User user) {
		log.debug( "Updating vendor with ID: " + user.getId());
		return adminService.updateVendor(user);
	}

	// Below method is use for delete the vendor
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@DeleteMapping("/deleteVendor/{userId}")
	public String deleteVender(@PathVariable("userId") Integer id) {
		log.debug("Deleting vendor with ID: {}", id);
		return adminService.deleteVendor(id);
	}

	// Below list is use for viewing feedback
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@GetMapping("/viewFeedback")
	public List<Feedback> getAllFeedback() {
		log.debug("Retrieving all feedback");
		return adminService.getAllFeedback();
	}

	// Below list is use for view bill
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@GetMapping("/viewBill")
	public List<Billing> getAllBill() {
		log.debug("Retrieving all bills");
		return adminService.getAllBill();
	}

}
