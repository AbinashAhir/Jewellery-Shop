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

@Setter
@Getter
@Entity
@ToString
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "feedbackid")
	private int id;

//	@NotBlank(message = "Feedback can't be blank.")
	private String feedback;

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

	@OneToOne(cascade = CascadeType.PERSIST)

	@JoinColumn(name = "userid", referencedColumnName = "id")
	private User user;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "productid", referencedColumnName = "productId")
	private Product product;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "purchaseid", referencedColumnName = "purchaseid")
	private Purchase purchase;

}