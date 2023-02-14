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

		
		if(!productRepository.findById(productId).isPresent()) {
			throw new ProductNotFoundException("Product not found with id");
		} else {
			return productRepository.findById(productId);
		}
		
	}

//	@Override
//	public List<Product> getAllProductByProductName(String productName) {
//		return crepo.findAll().stream().filter(e->e.productName).toList();
//	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product getAllProductByProductName(String productName) {
		return productRepository.findByProductName(productName).orElse(null);
	}

	@Override
	public Product getProduct(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getFeedbackByProductName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String purchaseProduct(int uid, int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int uid) {
		User userById = userRepository.findById(uid).get();
		return userById;
	}

	@Override
	public Product getProductById(int pid) {
		Optional<Product> product = productRepository.findById(pid);

		return product.get();
	}

	@Override
	public void savePurchase(Purchase purchase) {
		purchaseRepository.save(purchase);

	}

	@Override
	public Purchase getPurchaseById(int purchaseId) {
		Optional<Purchase> purchaseById = purchaseRepository.findById(purchaseId);
		Purchase purchase = purchaseById.get();
		return purchase;
	}

	@Override
	public void saveFeedBack(Feedback feedback) {
		feedbackRepository.save(feedback);

	}

	@Override
	public Billing getBill(Billing bill) {

		bill.setPurchase(bill.getPurchase());
		bill.setUser(bill.getUser());
		bill.setTotalCost(bill.getTotalCost());

		return bill;

	}

	@Override
	public void saveBill(Billing bill) {
		billingRepository.save(bill);

	}

	@Override
	public double getTotalCost(int purchaseId) {
		Optional<Purchase> purchaseById = purchaseRepository.findById(purchaseId);
		Purchase purchase = purchaseById.get();
		double cost = purchase.getProduct().getProductCost();
		double quantity = purchase.getQuantity();
		double totalCost = cost * quantity;
		return totalCost;
	}

	@Override
	public User getUserByPurchaseId(int purchaseId) {
		Purchase purchase = purchaseRepository.findById(purchaseId).get();
		User userById = purchase.getUser();
		return userById;
	}

//	@Override
//	public Product getProduct(String productName) {
//		return crepo.findProduct(productName).orElse(null);
//	}
//
//	@Override
//	public Product getFeedbackByProductName(String string) {
//		return crepo.findProduct(productName).orElse(null);
//	}

}
