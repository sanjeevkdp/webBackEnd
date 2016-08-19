package com.niit.dao;

import java.util.List;

import com.niit.model.OrderItems;

public interface OrderItemsDao {

	void saveOrUpdate(OrderItems orderItems);

	void delete(String orderItems_id);

	List<OrderItems> listOrderItems();

}
