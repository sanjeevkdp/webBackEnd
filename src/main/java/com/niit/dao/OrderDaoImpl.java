package com.niit.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.OrderD;

@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {
	@Autowired
	SessionFactory sessionFactory;

	public OrderDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(OrderD order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);

	}

	@Transactional
	public void delete(String order_id) {
		OrderD orderDetailTodelete = new OrderD();
		orderDetailTodelete.setOrder_id(order_id);

	}

	@Transactional
	public List<OrderD> listOrder() {
		String hql = "from Order";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<OrderD> listOfOrder = query.getResultList();
		return listOfOrder;
	}

}
