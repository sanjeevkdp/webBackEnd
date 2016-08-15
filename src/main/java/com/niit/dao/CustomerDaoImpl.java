package com.niit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Authorities;
import com.niit.model.Category;
import com.niit.model.Customer;
import com.niit.model.Users;
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
//       users newUser=new users();
//       newUser.setUsername(customer.getUserName());
//       newUser.setPassword(customer.getPassword());
//       newUser.setEnabled(true);
//     newUser.setCustomerId(customer.getCustomerId());
//    
//       Authorities authorities=new Authorities();
//       authorities.setUserName(customer.getUserName());
//       authorities.setAuthority("ROLE_USER");
//       sessionFactory.getCurrentSession().saveOrUpdate(newUser);
//       sessionFactory.getCurrentSession().saveOrUpdate(authorities);
	}

	@Transactional
	public Customer get(String customerId) {
		return sessionFactory.getCurrentSession().get(Customer.class, customerId);

	}

//	@Override
//	public List<Customer> list() {
//		String hql = "from Customer";
//		Query query = sessionFactory.getCurrentSession().createQuery(hql);
//		List<Customer> listOfCustomers = query.getResultList();
//		return listOfCustomers;
//	}
	@Transactional
	public List<Customer> list() {
		@SuppressWarnings("unchecked")
		List<Customer> listCustomer = (List<Customer>) sessionFactory.getCurrentSession()
		.createCriteria(Customer.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCustomer;
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
