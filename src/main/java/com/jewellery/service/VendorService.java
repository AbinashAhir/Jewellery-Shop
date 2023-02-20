package com.jewellery.service;

import java.util.Collection;
import java.util.List;

import com.jewellery.entity.Billing;
import com.jewellery.entity.Product;
import com.jewellery.exception.DuplicateItemException;

public interface VendorService {
	

	public String addProduct(Product product) throws DuplicateItemException;

	

	public String updateProduct(Product product);

	public Billing getBillingById(Integer customerId, Integer purchaseId);
	public String deleteProduct(Integer productId);
	
//	public String deleteProduct(Product product);
	

	
}

