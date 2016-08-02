package com.niit.dao;


	import java.util.List;

	import org.hibernate.Criteria;
	import org.hibernate.SessionFactory;
	import org.hibernate.query.Query;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

	import com.niit.model.Cart;

	@Repository("cartDao")
	public class CartDaoImpl  implements CartDao{

		@Autowired
			private SessionFactory sessionFactory;

		public CartDaoImpl(SessionFactory sessionFactory) {
				this.sessionFactory = sessionFactory;

			}

		@Transactional
			public void saveOrUpdate(Cart cart) {
				sessionFactory.getCurrentSession().saveOrUpdate(cart);

			}

		@Transactional
			public void delete(String id) {
				Cart cartToDelete = new Cart();
				cartToDelete.setId(id);
				sessionFactory.getCurrentSession().delete(cartToDelete);

			}

		@Transactional
			public Cart get(String id) {

				// sessionFactory.getCurrentSession().get(Cart.class,id);
				String hql = "from Cart where Id=" + "'" + id + "'";
				Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
				List<Cart> listcart = (List<Cart>) query.getResultList();
				if (listcart != null && !listcart.isEmpty()) {
					return listcart.get(0);
				}
				return null;
			}

		@Transactional
			public List<Cart> list() {
				@SuppressWarnings("unchecked")
				List<Cart> listcart = (List<Cart>) sessionFactory.getCurrentSession()
				.createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
				return listcart;
			}

	}


