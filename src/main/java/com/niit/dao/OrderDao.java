package com.niit.dao;

import java.util.List;

import com.niit.model.Order;

public interface OrderDao {

	void saveOrUpdate(Order order);

	void delete(String order_id);

	List<Order> listOrder();
}
