package com.makeanthon.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.makeanthon.cart.entity.Cart;
import com.makeanthon.cart.service.CartService;

@RestController
public class CartServiceController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping(value="/cart/{userId}")
	public Cart getCartProducts(@PathVariable("userId") String userId){

		return cartService.getUserCartProducts(userId);
	}
	
	@PostMapping(value="/cart")
	public String updateItemToCart( @RequestBody Cart selctedProduct){

		cartService.addTocart(selctedProduct);
		return "Added item to cart successfully";
	}
	
	@DeleteMapping(value="/cart/{userId}/{productId}")
	public String deleteItemFromCart(@PathVariable("userId") String userId, @PathVariable("productId") String productId){

		cartService.deleteFromCart(userId, productId);
		return "Deleted item to cart successfully";
	}

}