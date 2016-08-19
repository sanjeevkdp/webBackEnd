package com.niit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.ShippingAddress;

public class ShippingAddressDaoImpl implements ShippingAddressDao{
	@Autowired
	private SessionFactory sessionFactory;

	public ShippingAddressDaoImpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;

		}

	@Transactional
		public void saveOrUpdate(ShippingAddress shippingAddress) {
			sessionFactory.getCurrentSession().saveOrUpdate(shippingAddress);

		}

	

	@Transactional
		public void delete(String shippingAddress_id) {
		ShippingAddress supToDelete = new ShippingAddress();
			supToDelete.setShippingAddress_id(shippingAddress_id);
			sessionFactory.getCurrentSession().delete(supToDelete);

		}

	@Transactional
		public ShippingAddress get(String shippingAddress_id) {

			// sessionFactory.getCurrentSession().get(ShippingAddress.class,shippingAddress_id);
			String hql = "from ShippingAddress where shippingAddress_id=" + "'" + shippingAddress_id + "'";
			Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
			List<ShippingAddress> listAdd = (List<ShippingAddress>) query.getResultList();
			if (listAdd != null && !listAdd.isEmpty()) {
				return listAdd.get(0);
			}
			return null;
		}

	@Transactional
		public List<ShippingAddress> list() {
			@SuppressWarnings("unchecked")
			List<ShippingAddress> listAdd= (List<ShippingAddress>) sessionFactory.getCurrentSession()
			.createCriteria(ShippingAddress.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listAdd;
		}

}
