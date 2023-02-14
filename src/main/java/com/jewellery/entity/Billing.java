package com.jewellery.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Billing {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	private double totalCost;

	// this method is use for fetching id..
	public long getId() {
		return id;
	}

	// this method is use for setting id variable
	public void setId(long id) {
		this.id = id;
	}

	// this method is use for fetching user
	public User getUser() {
		return user;
	}

	// this method is use for setting user variable
	public void setUser(User user) {
		this.user = user;
	}

	// this method is use for fetching purchase
	public Purchase getPurchase() {
		return purchase;
	}

	// this method is use for setting purchase of purchase type..
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	// this method is use for fetching totalcost
	public double getTotalCost() {
		return totalCost;
	}

	// this method is use for setting totalcost variable
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	// mapping to the user table with the reference of userid
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "userid", referencedColumnName = "id")
	private User user;

	// mapping to the purchase table with the reference of purchaseid
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "purchaseid", referencedColumnName = "purchaseid")
	private Purchase purchase;

}
