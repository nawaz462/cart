package com.makeanthon.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.makeanthon.cart.dao.CartServiceDAO;
import com.makeanthon.cart.entity.Cart;

@Component
public class CartService {
	
	@Autowired
	CartServiceDAO cartServiceDao;
	
	public Cart getUserCartProducts(String userId){
		
		return cartServiceDao.getUserCartProducts(userId);
	}

	public void addTocart(Cart selctedProduct) {

		Cart userSelectedProducts = cartServiceDao.getUserCartProducts(selctedProduct.getUserId());
		if(userSelectedProducts != null) {
			userSelectedProducts.getUserSelectedProducts().addAll(selctedProduct.getUserSelectedProducts());
			cartServiceDao.updateUserCart(userSelectedProducts);
		}
		else
			cartServiceDao.addCartProduct(selctedProduct);
	
	}
	
	public void deleteFromCart(String userId, String productId) {

		Cart userSelectedProducts = cartServiceDao.getUserCartProducts(userId);
		userSelectedProducts.getUserSelectedProducts().removeIf(s-> s.getProductId().equals(productId));
		cartServiceDao.updateUserCart(userSelectedProducts);
	}
}
