package com.niit.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.OrderItems;
@Repository("orderItemsDao")
public class OrderItemsDaoImpl implements OrderItemsDao {

	@Autowired
	SessionFactory sessionFactory;

	public OrderItemsDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(OrderItems orderItems) {
		sessionFactory.getCurrentSession().saveOrUpdate(orderItems);

	}

	@Transactional
	public void delete(String orderItems_id) {
		OrderItems orderedItemsTodelete = new OrderItems();
		orderedItemsTodelete.setOrderItems_id(orderItems_id);
		sessionFactory.getCurrentSession().delete(orderedItemsTodelete);

	}

	@Transactional
	public List<OrderItems> listOrderItems() {
		String hql="from OrderItems";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<OrderItems> listOfOrderedItems = query.getResultList();
		return listOfOrderedItems;
	}
}
