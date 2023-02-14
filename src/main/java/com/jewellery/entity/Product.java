package com.jewellery.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Product implements Serializable {

	private static final long serialVersionUID = -3966420328222306500L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int productId;
	@NotBlank(message = "Product name is required")
	private String productName;
	@NotBlank(message = "Product material is required")
	private String productMaterial;
	@NotNull(message = "Product weight is required")
	@Min(value=0, message="Product product weight should be more than zero.")
	private double productWeight;
	@NotNull(message = "Product gram per weight is required")
	@Min(value=0, message="Product productGmPerWeight should be more than zero.")
	private double productGmPerWeight;
	@NotNull(message = "Product quantity is required")
	@Min(value=1, message="Product quantity can't be zero.")
	private int productQuantity;
	@NotNull(message = "Product cost is required")
	@Min(value=1, message="Product cost can't be zero.")
	private double productCost;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductMaterial() {
		return productMaterial;
	}

	public void setProductMaterial(String productMaterial) {
		this.productMaterial = productMaterial;
	}

	public double getProductWeight() {
		return productWeight;
	}

	public void setProductWeight(double productWeight) {
		this.productWeight = productWeight;
	}

	public double getProductGmPerWeight() {
		return productGmPerWeight;
	}

	public void setProductGmPerWeight(double productGmPerWeight) {
		this.productGmPerWeight = productGmPerWeight;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

}
