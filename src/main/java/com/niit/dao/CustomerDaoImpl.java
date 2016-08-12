package com.niit.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Customer;
@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao{
	@Autowired
	SessionFactory sessionFactory;

	public CustomerDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);

	}

	@Transactional
	public Customer get(String customerId) {
		return sessionFactory.getCurrentSession().get(Customer.class, customerId);

	}

	@Override
	public List<Customer> list() {
		String hql = "from Customer";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Customer> listOfCustomers = query.getResultList();
		return listOfCustomers;
	}

	@Transactional
	public Customer getCustomerByUserName(String userName) {
		String hql = "from Customer where userName=" + "'" + userName + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Customer> listOfCustomers = query.getResultList();
		if (listOfCustomers != null && !listOfCustomers.isEmpty()){
			return  listOfCustomers.get(0);
		}
			
		
		return null;

	}
}
