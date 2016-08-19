package com.niit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.BillingAddress;
@Repository("billingAddressDao")
public class BillingAddressDaoIml implements BillingAddressDao{

	@Autowired
	private SessionFactory sessionFactory;

	public BillingAddressDaoIml(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;

		}

	@Transactional
		public void saveOrUpdate(BillingAddress billingAddress) {
			sessionFactory.getCurrentSession().saveOrUpdate(billingAddress);

		}

	

	@Transactional
		public void delete(String billingAddress_id) {
		BillingAddress supToDelete = new BillingAddress();
			supToDelete.setBillingAddress_id(billingAddress_id);
			sessionFactory.getCurrentSession().delete(supToDelete);

		}

	@Transactional
		public BillingAddress get(String billingAddress_id) {

			// sessionFactory.getCurrentSession().get(BillingAddress.class,billingAddress_id);
			String hql = "from BillingAddress where billingAddress_id=" + "'" + billingAddress_id + "'";
			Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
			List<BillingAddress> listAdd = (List<BillingAddress>) query.getResultList();
			if (listAdd != null && !listAdd.isEmpty()) {
				return listAdd.get(0);
			}
			return null;
		}

	@Transactional
		public List<BillingAddress> list() {
			@SuppressWarnings("unchecked")
			List<BillingAddress> listAdd= (List<BillingAddress>) sessionFactory.getCurrentSession()
			.createCriteria(BillingAddress.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listAdd;
		}
}
