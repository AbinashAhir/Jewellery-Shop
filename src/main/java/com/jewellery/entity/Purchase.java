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

/*
 * This is the class purchase which contains purchase Details like purchase id
 * ,purchase quantity
 */

@Entity
@Getter
@Setter
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "purchaseid")
	private Long purchaseId;

	@NotNull(message = "Product quantity is required")
	@Min(value = 1, message = "Product quantity can't be zero.")
	private Long quantity;

	// mapping to the user table with the reference of id

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "userid", referencedColumnName = "id")
	private User user;

	// mapping to the product table with the reference of product ID

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "productid", referencedColumnName = "productId")
	private Product product;

}
