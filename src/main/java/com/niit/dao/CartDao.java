package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;

public interface CartDao {

	
	
void saveOrUpdate(Cart cart);
	
	void delete(String cartId);
	
	Cart getCartByCustomerId(String customerId);
	
	List<Cart> listCart();
	
}
