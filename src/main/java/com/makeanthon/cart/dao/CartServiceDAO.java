package com.makeanthon.cart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.makeanthon.cart.entity.Cart;
import com.mongodb.client.result.UpdateResult;

@Component
public class CartServiceDAO {

	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public Cart getUserCartProducts(String userId){
		
		Criteria searchByNameCriteria = Criteria.where("userId").is(userId);
		return mongoTemplate.findOne(Query.query(searchByNameCriteria), Cart.class);
	}
	
	public void addCartProduct(Cart cartWithProduct){
		
		mongoTemplate.save(cartWithProduct);
	}

	public UpdateResult updateUserCart(Cart userCart) {

		Criteria add = Criteria.where("userId").is(userCart.getUserId());
		Update updateCart = new Update() ;
		updateCart.set("userSelectedProducts", userCart.getUserSelectedProducts());
		updateCart.set("totalCartAmount", userCart.getTotalCartAmount());
		
		return mongoTemplate.upsert(new Query(add), updateCart, Cart.class);
	}
}
