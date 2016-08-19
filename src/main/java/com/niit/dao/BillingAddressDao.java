package com.niit.dao;

import java.util.List;

import com.niit.model.BillingAddress;

public interface BillingAddressDao {
void saveOrUpdate(BillingAddress billingAddress);
	
	

	void delete(String billingAddress_id);

	BillingAddress get(String billingAddress_id);

	public List<BillingAddress> list();
}
