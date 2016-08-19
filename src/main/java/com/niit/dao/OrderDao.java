package com.niit.dao;

import java.util.List;

import com.niit.model.OrderD;

public interface OrderDao {

	void saveOrUpdate(OrderD order);

	void delete(String order_id);

	List<OrderD> listOrder();
}
