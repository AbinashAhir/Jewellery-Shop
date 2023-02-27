package com.jewellery.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jewellery.entity.Billing;
import com.jewellery.entity.Feedback;
import com.jewellery.entity.Product;
import com.jewellery.entity.Purchase;
import com.jewellery.entity.User;
import com.jewellery.exception.ProductNotFoundException;
import com.jewellery.exception.UserNotFoundException;
import com.jewellery.service.CustomerService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	Logger log = org.slf4j.LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	// below method is use for searching the product by productname
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	@GetMapping("/search/{productName}")
	public Product getAllProductByProductName(@PathVariable("productName") String productName)
			throws ProductNotFoundException {
		log.debug("Searching for product with name: {}", productName);
		if (productName.equals(null)) {
			throw new ProductNotFoundException("Product Name is null");
		} else {
			log.debug("Found product with name: {}", productName);
			return customerService.getAllProductByProductName(productName);
		}
	}

	// below method is use for searching the product by productid
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	@GetMapping("/search/id/{productid}")
	public Optional<Product> getAllProductByProductId(@PathVariable("productid") Integer productid)
			throws ProductNotFoundException {
		log.debug("Found product with ID: {}", productid);
		return customerService.getAllProductByProductId(productid);
	}

	// below method is use for viewing the product..
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	@GetMapping("/viewProducts")
	public List<Product> getAllProduct() {
		log.debug("Retrieving all products");
		return customerService.getAllProduct();
	}

	// below method is use for purchase the product by customer
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "!hasRole('ROLE_ADMIN') && !hasRole('ROLE_VENDOR')")
	@PostMapping("/purchase/{uid}/{pid}")
	public String purchaseProduct(@Valid @RequestBody Purchase purchase, @PathVariable("uid") int uid,
			@PathVariable("pid") int pid) {
		log.debug("Processing purchase request for user ID {} and product ID {}", uid, pid);
		User user = customerService.getUserById(uid);
		purchase.setUser(user);
		Product product = customerService.getProductById(pid);
		purchase.setProduct(product);
		customerService.savePurchase(purchase);
		return "Product Purchased by " + user.getFirstName();
	}

	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_USER')")

	@PostMapping("/feedback/{customerId}/{purchaseId}")
	public String giveFeedbackByProductName(@RequestBody Feedback feedback, @PathVariable("customerId") int customerId,
			@PathVariable("purchaseId") int purchaseId) throws UserNotFoundException, Exception {
		
		log.debug("Received request to give feedback for customerId={} and purchaseId={}", customerId, purchaseId);

		User user = customerService.getUserById(purchaseId);
		if (user == null) {
			log.error("User with id: {} not found", customerId);
          throw new UserNotFoundException("User with id: " + customerId + " not found");
		}
		feedback.setUser(user);

		Purchase purchase = customerService.getPurchaseById(purchaseId);
		if (purchase == null) {
			log.error("Purchase with id: {} not found", purchaseId);
			throw new UserNotFoundException("Purchase with id: " + purchaseId + " not found");
		}
		feedback.setPurchase(purchase);

		Product product = customerService.getProductById(purchaseId);
		if (product == null) {
			log.error("Product with id: {} not found", purchaseId);
			throw new UserNotFoundException("Product with id: " + purchaseId + " not found");
		}
		feedback.setProduct(product);
//		

		customerService.saveFeedBack(feedback);
		log.info("Feedback saved successfully");
		return feedback.getFeedback();

	}

	// below code is use for generating bill for the customer

	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	@GetMapping("/getBill/{purchaseId}")
	public Billing getBill(@PathVariable("purchaseId") int purchaseId) throws UserNotFoundException, Exception {
		log.debug("Received request to get bill for purchaseId={}", purchaseId);
		User user = customerService.getUserByPurchaseId(purchaseId);
		if (user == null) {
			log.error("User not found for purchaseId={}", purchaseId);
			throw new UserNotFoundException("User with id: " + user + " not found");
		}

		Billing bill = new Billing();
		bill.setUser(user);

		Purchase purchase = customerService.getPurchaseById(purchaseId);
		if (purchase == null) {
			log.error("Purchase not found for purchaseId={}", purchaseId);
			throw new UserNotFoundException("Purchase with id: " + purchaseId + " not found");
		}

		bill.setPurchase(purchase);

		bill.setTotalCost(customerService.getTotalCost(purchaseId));

		customerService.saveBill(bill);
		log.info("Bill generated successfully for purchaseId={}", purchaseId);
		return bill;
	}

}
