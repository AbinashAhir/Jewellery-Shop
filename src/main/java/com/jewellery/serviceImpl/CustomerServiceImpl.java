package com.jewellery.serviceImpl;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jewellery.entity.Billing;
import com.jewellery.entity.Feedback;
import com.jewellery.entity.Product;

import com.jewellery.entity.Purchase;
import com.jewellery.entity.User;
import com.jewellery.exception.ProductNotFoundException;
import com.jewellery.repository.BillingRepository;
import com.jewellery.repository.FeedbackRepository;
import com.jewellery.repository.ProductRepository;
import com.jewellery.repository.PurchaseRepository;
import com.jewellery.repository.UserRepository;
import com.jewellery.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PurchaseRepository purchaseRepository;

	@Autowired
	private FeedbackRepository feedbackRepository;

	@Autowired
	private BillingRepository billingRepository;

	@Override
	public Optional<Product> getAllProductByProductId(Integer productId) throws ProductNotFoundException {

		// this method is use for fetching all product by product id
		if (!productRepository.findById(productId).isPresent()) {
			throw new ProductNotFoundException("Product not found with id");
		} else {
			return productRepository.findById(productId);
		}

	}

	// below code is creating list to store all product of product type
	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	// this method is use for fetching all product by productname
	@Override
	public Product getAllProductByProductName(String productName) {
		return productRepository.findByProductName(productName).orElse(null);
	}

	// this method is use for fetching User by uid
	@Override
	public User getUserById(int uid) {
		User userById = userRepository.findById(uid).get();
		return userById;
	}

	// this method is use for fetching Product by product id
	@Override
	public Product getProductById(int pid) {
		Optional<Product> product = productRepository.findById(pid);

		return product.get();
	}

	// this method is use to save purchase
	@Override
	public void savePurchase(Purchase purchase) {
		purchaseRepository.save(purchase);

	}

	// this method is use for fetching Purchase by Purchase Id
	@Override
	public Purchase getPurchaseById(int purchaseId) {
		Optional<Purchase> purchaseById = purchaseRepository.findById(purchaseId);
		Purchase purchase = purchaseById.get();
		return purchase;
	}

	// this method is use to save Feedback
	@Override
	public void saveFeedBack(Feedback feedback) {
		feedbackRepository.save(feedback);

	}

	// this method is use for fetching Bill
	@Override
	public Billing getBill(Billing bill) {

		bill.setPurchase(bill.getPurchase());
		bill.setUser(bill.getUser());
		bill.setTotalCost(bill.getTotalCost());

		return bill;

	}

	// this method is use to save the bills
	@Override
	public void saveBill(Billing bill) {
		billingRepository.save(bill);

	}

	// this method is use for fetching total cost
	@Override
	public double getTotalCost(int purchaseId) {
		Optional<Purchase> purchaseById = purchaseRepository.findById(purchaseId);
		Purchase purchase = purchaseById.get();
		double cost = purchase.getProduct().getProductCost();
		double quantity = purchase.getQuantity();
		double totalCost = cost * quantity;
		return totalCost;
	}

	// this method is use for fetching User by Purchase Id
	@Override
	public User getUserByPurchaseId(int purchaseId) {
		Purchase purchase = purchaseRepository.findById(purchaseId).get();
		User userById = purchase.getUser();
		return userById;
	}

//	@Override
//	public Product getProduct(String productName) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public Product getProduct(String productName) {
//		return productRepository.findProduct(productName).orElse(null);
//	}

}
