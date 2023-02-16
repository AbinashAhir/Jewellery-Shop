package com.jewellery.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * This is the class feedback which contain feedback detials about the
 * product,purchase id and user
 */

@Entity
@ToString
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "feedbackid")
	private int id;

	@NotBlank(message = "Feedback can't be blank.")
	private String feedback;


	// this method is use for fetching id..
	public int getId() {
		return id;
	}
	// this method is use for setting id
			public void setId(int id) {
				this.id = id;
	}
	// this method is use for fetching feedback..
	public String getFeedback() {
		return feedback;
	}

	// this method is use for setting feedback
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	// this method is use for fetching User..
	public User getUser() {
		return user;
	}
	// this method is use for fetching product..
	public Product getProduct() {
		return product;
	}
	// this method is use for fetching Purchase..
	public Purchase getPurchase() {
		return purchase;
	}
//
//	// this method is use for setting purchase variable
//	public void setPurchase(Purchase purchase) {
//		this.purchase = purchase;
//	}
//	
//	
//	// this method is use for setting Product variable of product type
//		public void setProduct(Product product) {
//			this.product = product;
//	}
//	// this method is use for setting user variable
//		public void setUser(User user) {
//			this.user = user;
//	}


	// Mapping to the user table by userid with the reference of id
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "userid", referencedColumnName = "id")
	private User user;

	// mapping to the product table with the reference of column name productid
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "productid", referencedColumnName = "productId")
	private Product product;

	// mapping to the purchase table with the reference of column name purchaseid
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "purchaseid", referencedColumnName = "purchaseid")
	private Purchase purchase;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	
	

}