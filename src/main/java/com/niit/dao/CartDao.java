package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;

public interface CartDao {
	void saveOrUpdate(Cart cart);

	Cart get(String id);

	public List<Cart> list();
	
   Cart create(Cart cart);
	
	Cart read(String cart_id);
	
	void delete(String cart_id);

	void update(String cart_id, Cart cart);
	
	

	




}
