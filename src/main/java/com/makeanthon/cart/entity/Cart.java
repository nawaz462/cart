package com.makeanthon.cart.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cart")
public class Cart {

	private String userId;
	private List<UserSelectedProdcuts> userSelectedProducts;
	private Long totalCartAmount;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<UserSelectedProdcuts> getUserSelectedProducts() {
		return userSelectedProducts;
	}

	public void setUserSelectedProducts(List<UserSelectedProdcuts> userSelectedProducts) {
		this.userSelectedProducts = userSelectedProducts;
	}

	public Long getTotalCartAmount() {
		return totalCartAmount;
	}

	public void setTotalCartAmount(Long totalCartAmount) {
		this.totalCartAmount = totalCartAmount;
	}
	
	public Cart() {
		
	}
	
}

