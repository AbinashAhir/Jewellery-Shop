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
	@Min(value = 0, message = "Product product weight should be more than zero.")
	private double productWeight;
	@NotNull(message = "Product gram per weight is required")
	@Min(value = 0, message = "Product productGmPerWeight should be more than zero.")
	private double productGmPerWeight;
	@NotNull(message = "Product quantity is required")
	@Min(value = 1, message = "Product quantity can't be zero.")
	private int productQuantity;
	@NotNull(message = "Product cost is required")
	@Min(value = 1, message = "Product cost can't be zero.")
	private double productCost;

	// this method is use for fetching product
	public int getProductId() {
		return productId;
	}

	// this method is use for setting product id
	public void setProductId(int productId) {
		this.productId = productId;
	}

	// this method is use for fetching product name
	public String getProductName() {
		return productName;
	}

	// this method is use for setting product name
	public void setProductName(String productName) {
		this.productName = productName;
	}

	// this method is use for fetching product material
	public String getProductMaterial() {
		return productMaterial;
	}

	// this method is use for setting product material
	public void setProductMaterial(String productMaterial) {
		this.productMaterial = productMaterial;
	}

	// this method is use for fetching product weight
	public double getProductWeight() {
		return productWeight;
	}

	// this method is use for setting product weight
	public void setProductWeight(double productWeight) {
		this.productWeight = productWeight;
	}

	// this method is use for fetching productGmPerweight
	public double getProductGmPerWeight() {
		return productGmPerWeight;
	}

	// this method is use for setting productGmPerWeight
	public void setProductGmPerWeight(double productGmPerWeight) {
		this.productGmPerWeight = productGmPerWeight;
	}

	// this method is use for fetching product Quantity
	public int getProductQuantity() {
		return productQuantity;
	}

	// this method is use for setting product Quantity
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	// this method is use for fetching product cost
	public double getProductCost() {
		return productCost;
	}

	// this method is use for setting product cost
	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}

	// this method is use for fetching serial version UID
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// checking value is present or not if true then it is present
	public static boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

}
