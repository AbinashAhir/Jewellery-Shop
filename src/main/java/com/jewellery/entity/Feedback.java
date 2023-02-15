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

@Setter
@Getter
@Entity
@ToString
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "feedbackid")
	private int id;

	@NotBlank(message = "Feedback can't be blank.")
	private String feedback;

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

}