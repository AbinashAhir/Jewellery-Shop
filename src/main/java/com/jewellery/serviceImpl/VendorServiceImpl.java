package com.jewellery.serviceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jewellery.entity.Billing;
import com.jewellery.entity.Product;
import com.jewellery.entity.Purchase;
import com.jewellery.entity.User;
import com.jewellery.exception.DuplicateItemException;
import com.jewellery.exception.UserAlreadyExistException;
import com.jewellery.repository.ProductRepository;

import com.jewellery.repository.PurchaseRepository;

import com.jewellery.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private PurchaseRepository pp;

	@Override
	public String addProduct(Product product) throws DuplicateItemException {

		if (productRepository.findByProductName(product.getProductName()).isPresent()) {
			throw new DuplicateItemException("Duplicate item.");
		} else {
			productRepository.save(product);
			return "Product Added Successfully";
		}

	}

	@Override
	public String updateProduct(Product product) {
		Product productId = productRepository.findById(product.getProductId()).get();

		if (Objects.nonNull(product.getProductId())) {

			productId.setProductId(product.getProductId());
		}

		if (Objects.nonNull(product.getProductName()) && !"".equalsIgnoreCase(product.getProductName())) {
			productId.setProductName(product.getProductName());
		}

		if (Objects.nonNull(product.getProductMaterial()) && !"".equalsIgnoreCase(product.getProductMaterial())) {
			productId.setProductMaterial(product.getProductMaterial());
		}

		if (Objects.nonNull(product.getProductWeight())) {
			productId.setProductWeight(product.getProductWeight());
		}

		if (Objects.nonNull(product.getProductGmPerWeight())) {
			productId.setProductGmPerWeight(product.getProductGmPerWeight());
		}

		if (Objects.nonNull(product.getProductQuantity())) {
			productId.setProductQuantity(product.getProductQuantity());
		}

		if (Objects.nonNull(product.getProductCost())) {
			productId.setProductCost(product.getProductCost());
		}

		productRepository.save(productId);

		return productId.getProductName() + " updated successfully";
	}


	@Override
	public Billing getBillingById(Integer customerId, Integer purchaseId) {
//		Billing bl = new Billing();
//		bl.setCustomerId(customerId);
//		Registration user = rp.findById(customerId).orElse(null);
//
//		if (user != null) {
//			return user.getPurchases().stream().map(Purchase::getProduct).collect(Collectors.toList());
//
//		} else {
//			return null;
//		}
		return null;

	}


	@Override
	public String deleteProduct(Integer productId) {
		productRepository.deleteById(productId);
		return "Product Deleted";
	
	}

}
