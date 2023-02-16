package com.jewellery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jewellery.entity.Billing;
import com.jewellery.entity.Feedback;
import com.jewellery.entity.Product;
import com.jewellery.entity.Purchase;
import com.jewellery.entity.User;
import com.jewellery.exception.ProductNotFoundException;
import com.jewellery.exception.UserNotFoundException;

import com.jewellery.repository.ProductRepository;
import com.jewellery.service.CustomerService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// below method is use for searching the product by productname
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	@GetMapping("/search/{productName}")
	public Product getAllProductByProductName(@PathVariable("productName") String productName)
			throws ProductNotFoundException {

		if (productName.equals(null)) {
			throw new ProductNotFoundException("Product Name is null");
		} else {
			return customerService.getAllProductByProductName(productName);
		}
	}

	// below method is use for searching the product by productid
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	@GetMapping("/search/id/{productid}")
	public Optional<Product> getAllProductByProductId(@PathVariable("productid") Integer productid)
			throws ProductNotFoundException {
		return customerService.getAllProductByProductId(productid);
	}

	// below method is use for viewing the product..
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	@GetMapping("/viewProducts")
	public List<Product> getAllProduct() {
		return customerService.getAllProduct();
	}

	// below method is use for purchase the product by customer
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	@PostMapping("/purchase/{uid}/{pid}")
	public String purchaseProduct(@Valid @RequestBody Purchase purchase, @PathVariable("uid") int uid,
			@PathVariable("pid") int pid) {
		User user = customerService.getUserById(uid);
		purchase.setUser(user);
		Product product = customerService.getProductById(pid);
		purchase.setProduct(product);
		customerService.savePurchase(purchase);
		return "Product Purchased by " + user.getFirstName();
	}

//	@SecurityRequirement(name = "Bearer Authentication")
//	@PreAuthorize(value = "hasRole('ROLE_USER')")
//	@PostMapping("/feedback/{customerId}/{purchaseId}")
//	public String giveFeedbackByProductName(@RequestBody Feedback feedback, @PathVariable("customerId") int customerId,
//			@PathVariable("purchaseId") int purchaseId) throws UserNotFoundException, Exception {
//
//		User user = customerService.getUserById(purchaseId);
//		if (user == null) {
//			throw new UserNotFoundException("User with id: " + customerId + " not found");
//		}
//		feedback.setUser(user);
//
//		Purchase purchase = customerService.getPurchaseById(purchaseId);
//		if (purchase == null) {
//			throw new UserNotFoundException("Purchase with id: " + purchaseId + " not found");
//		}
//		feedback.setPurchase(purchase);
//
//		Product product = customerService.getProductById(purchaseId);
//		if (product == null) {
//			throw new UserNotFoundException("Product with id: " + purchaseId + " not found");
//		}
//		feedback.setProduct(product);
//
//		customerService.saveFeedBack(feedback);
//		return feedback.getFeedback();
//	}
	
	
	@PostMapping("/feedback/{customerId}/{purchaseId}")
	public String giveFeedbackByProductName(@RequestBody Feedback feedback, @PathVariable("customerId")int customerId , @PathVariable("purchaseId")int purchaseId){
		User user = customerService.getUserById(purchaseId);
		feedback.setUser(user);
		Purchase purchase = customerService.getPurchaseById(purchaseId);
		feedback.setPurchase(purchase);
		Product product = customerService.getProductById(purchaseId);
		feedback.setProduct(product);
		customerService.saveFeedBack(feedback);
		return feedback.getFeedback();
	}

	// below code is use for generating bill for the customer

	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	@GetMapping("/getBill/{purchaseId}")
	public Billing getBill(@PathVariable("purchaseId") int purchaseId) throws UserNotFoundException, Exception {

		User user = customerService.getUserByPurchaseId(purchaseId);
		if (user == null) {
			throw new UserNotFoundException("User with id: " + user + " not found");
		}

		Billing bill = new Billing();
		bill.setUser(user);

		Purchase purchase = customerService.getPurchaseById(purchaseId);
		if (purchase == null) {
			throw new UserNotFoundException("Purchase with id: " + purchaseId + " not found");
		}

		bill.setPurchase(purchase);

		bill.setTotalCost(customerService.getTotalCost(purchaseId));

		customerService.saveBill(bill);

		return bill;
	}

}
