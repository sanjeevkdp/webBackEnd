package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;

public interface CartDao {
	
void saveOrUpdate(Cart cart);
	
	void editCart(Cart cart);

	void delete(String cart_id);

	Cart get(String cart_id);

	public List<Cart> list();
	
	Cart getCartByCustomerId(String customerId);

}
