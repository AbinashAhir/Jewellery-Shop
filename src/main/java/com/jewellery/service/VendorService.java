package com.jewellery.service;

import java.util.Collection;
import java.util.List;

import com.jewellery.entity.Billing;
import com.jewellery.entity.Product;


public interface VendorService {
	
	public String addProduct(Product product) ;
	public String updateProduct(Product product);
	public String deleteProduct(Product product);
	public Billing getBillingById(Integer customerId, Integer purchaseId);
	
}

