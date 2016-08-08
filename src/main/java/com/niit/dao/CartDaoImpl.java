package com.niit.dao;


	import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
	import org.hibernate.SessionFactory;
	import org.hibernate.query.Query;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

	import com.niit.model.Cart;

	@Repository("cartDao")
	public class CartDaoImpl  implements CartDao{
         
		private Map<String, Cart> listOfCart;
		
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
			public void delete(String cart_id) {
//			    Cart cartToDelete = new Cart();
//				cartToDelete.setCart_id(cart_id);
//				sessionFactory.getCurrentSession().delete(cartToDelete);
			if(listOfCart.keySet().contains(cart_id)){
				throw new IllegalArgumentException(String.format("can not delete Cart with given id(%)"
						+"does not"
						+"exist", cart_id));
				}
			listOfCart.remove(cart_id);
			}
		

			

		@Transactional
			public Cart get(String cart_id) {

				// sessionFactory.getCurrentSession().get(Cart.class,cart_id);
				String hql = "from Cart where Id=" + "'" + cart_id + "'";
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
		
		public CartDaoImpl() {
			// TODO Auto-generated constructor stub
               listOfCart=new HashMap<String,Cart>();	
		}
		
		@Override
		public Cart create(Cart cart) {
			// TODO Auto-generated method stub
			
			if(listOfCart.keySet().contains(cart.getCart_id())){
				throw new IllegalArgumentException(String.format("can not create Cart with given id(%)"
			+"already"
			+"exist", cart.getCart_id()));
			}
			listOfCart.put(cart.getCart_id(), cart);
			return cart;
		}

		@Override
		public Cart read(String cart_id) {
			// TODO Auto-generated method stub
			
			return listOfCart.get(cart_id);
		}

		@Override
		public void update(String cart_id, Cart cart) {
			// TODO Auto-generated method stub
			if(!listOfCart.keySet().contains(cart_id)){
				throw new IllegalArgumentException(String.format("can not update Cart with given id(%)"
						+"does not"
						+"exist", cart.getCart_id()));
				}
			listOfCart.put(cart_id, cart);
			}
		

	}


