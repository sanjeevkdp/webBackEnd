package com.niit.dao;

import java.util.List;

import com.niit.model.ShippingAddress;

public interface ShippingAddressDao {
void saveOrUpdate(ShippingAddress shippingAddress);
	
	

	void delete(String shippingAddress_id);

	ShippingAddress get(String shippingAddress_id);

	public List<ShippingAddress> list();

}
