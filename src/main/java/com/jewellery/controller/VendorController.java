package com.jewellery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {

	@Autowired
	private VendorService vs;

	@PostMapping("/add")
	public String addProduct(@Valid @RequestBody Product product) throws DuplicateItemException {
		return vs.addProduct(product);
	}

	@PutMapping("/update")
	public String updateProduct(@Valid @RequestBody Product product) {
		return vs.updateProduct(product);
	}

	@DeleteMapping("/delete")
	public String deleteProduct(@RequestBody Integer productId) {
		return vs.deleteProduct(productId);
	}


}
