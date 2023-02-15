package com.jewellery.service;

import java.util.List;
import java.util.Optional;

import com.jewellery.entity.Billing;
import com.jewellery.entity.Feedback;
import com.jewellery.entity.Product;

import com.jewellery.entity.Purchase;
import com.jewellery.entity.User;
import com.jewellery.exception.ProductNotFoundException;
import com.jewellery.exception.UserNotFoundException;

public interface CustomerService {

	public Optional<Product> getAllProductByProductId(Integer productId) throws ProductNotFoundException;

	public Product getAllProductByProductName(String productName);

	public List<Product> getAllProduct();

	public Purchase getPurchaseById(int purchaseId);

	public User getUserById(int uid) throws UserNotFoundException;

	public Product getProductById(int pid);

	public void savePurchase(Purchase purchase);

	public void saveFeedBack(Feedback feedback);

	public Billing getBill(Billing bill);

	public void saveBill(Billing bill);

	public double getTotalCost(int purchaseId);

	public User getUserByPurchaseId(int purchaseId);

//	Product getProduct(String productName);

}
