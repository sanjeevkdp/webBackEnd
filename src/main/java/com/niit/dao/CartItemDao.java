package com.niit.dao;

import java.util.List;

import com.niit.model.CartItem;

public interface CartItemDao {
	
	
	
void saveOrUpdate(CartItem cartItem);

     void persist(CartItem cartItem);
     
	void editCartItem(CartItem cartItem);

	void delete(String cartItem_id);

	CartItem get(String cartItem_id);

	public List<CartItem> list();
	
	List<CartItem> getCartItemsByCustomerId(String customerId);

}
