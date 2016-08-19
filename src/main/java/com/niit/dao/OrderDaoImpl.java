package com.niit.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Order;

@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {
	@Autowired
	SessionFactory sessionFactory;

	public OrderDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);

	}

	@Transactional
	public void delete(String order_id) {
		Order orderDetailTodelete = new Order();
		orderDetailTodelete.setOrder_id(order_id);

	}

	@Transactional
	public List<Order> listOrder() {
		String hql = "from Order";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Order> listOfOrder = query.getResultList();
		return listOfOrder;
	}

}
