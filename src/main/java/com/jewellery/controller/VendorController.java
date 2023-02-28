package com.jewellery.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jewellery.entity.Billing;
import com.jewellery.entity.Product;
import com.jewellery.exception.DuplicateItemException;
import com.jewellery.service.VendorService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

//@RequestMapping use to map web requests onto specific handler classes and/or handler methods. 

@RestController
@RequestMapping("/api/vendor")
public class VendorController {
	Logger log = org.slf4j.LoggerFactory.getLogger(VendorController.class);

	@Autowired
	private VendorService vendorService;

	// Below code is use for adding the product by the vendor
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_VENDOR')")
	@PostMapping("/add")
	public String addProduct(@Valid @RequestBody Product product) throws DuplicateItemException {
		log.debug("Received request to add new product with name={}", product.getProductName());
        return vendorService.addProduct(product);
	}

	// Below code is use for updating the product by the vendor
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_VENDOR')")
	@PutMapping("/update")
	public String updateProduct(@Valid @RequestBody Product product) {
		log.debug("Received request to update product with id={}", product.getProductId());
		return vendorService.updateProduct(product);
	}

	// Below code is use for deleting the product by the vendor
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_VENDOR')")
	@DeleteMapping("/delete/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId) {
		log.debug("Received request to delete product with id={}", productId);
		return vendorService.deleteProduct(productId);
	}
	
//	public String deleteProduct(@RequestBody Product product) {
//		return vendorService.deleteProduct(product);
//	}

}
