package com.jewellery.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

//This is the class purchase which contains purchase properties like purchase id ,purchase quantity
public class Purchase {
	/*
	 * here @Id annotation is use for making purchase id as a primary key
	 * and @GeneratedValue is use to generate purchase id in sequence
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "purchaseid")
	private Long purchaseId;

	// it will print message if user will not give the quantity or give zero
	@NotNull(message = "Product quantity is required")
	@Min(value = 1, message = "Product quantity can't be zero.")
	private Long quantity;

	// this method is use for fetching Purchase Id
	public Long getPurchaseId() {
		return purchaseId;
	}

	// this method is use for setting purchase id
	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}

	// this method is use for fetching Quantity
	public Long getQuantity() {
		return quantity;
	}

	// this method is use for setting Quantity
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	// this method is use for fetching user
	public User getUser() {
		return user;
	}

	// this method is use for setting user
	public void setUser(User user) {
		this.user = user;
	}

	// this method is use for fetching product
	public Product getProduct() {
		return product;
	}

	// this method is use for setting product
	public void setProduct(Product product) {
		this.product = product;
	}

	// mapping to the user table with the reference of id
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "userid", referencedColumnName = "id")
	private User user;

	// mapping to the product table with the reference of product ID
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "productid", referencedColumnName = "productId")
	private Product product;

}
