package com.niit.dao;

import java.util.List;

import com.niit.model.Customer;

public interface CustomerDao {
	
void saveOrUpdate(Customer customer);
	
	Customer get(String customerId);
	
	List<Customer> list();
	
	Customer getCustomerByUserName(String userName);

}
