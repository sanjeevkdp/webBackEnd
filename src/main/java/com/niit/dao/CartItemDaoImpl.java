package com.niit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.CartItem;

@Repository("cartItemDao")
public class CartItemDaoImpl implements CartItemDao {
	@Autowired
	private SessionFactory sessionFactory;

	public CartItemDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void persist(CartItem cartItem){
		sessionFactory.getCurrentSession().persist(cartItem);
	}
	
	@Transactional
	public void saveOrUpdate(CartItem cartItem) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
	}

	@Transactional
	public void editCartItem(CartItem cartItem) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
	}

	@Transactional
	public void delete(String cartItem_id) {
		CartItem cartItemToDelete = new CartItem();
		cartItemToDelete.setCartItem_id(cartItem_id);
		sessionFactory.getCurrentSession().delete(cartItemToDelete);

	}

	@Transactional
	public CartItem get(String cartItem_id) {
		// sessionFactory.getCurrentSession().get(CartItem.class, cartItem_id);
		String hql = "from CartItem where cartItem_id=" + "'" + cartItem_id + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<CartItem> listCartItem = (List<CartItem>) query.getResultList();
		if (listCartItem != null && !listCartItem.isEmpty()) {
			return listCartItem.get(0);
		}
		return null;
	}

	@Transactional
	public List<CartItem> list() {
		String hql = "from CartItem";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<CartItem> cartItems = query.getResultList();
		return cartItems;

	}
	@Transactional
	public List<CartItem> getCartItemsByCustomerId(String customerId) {
		String hql = "from CartItem where customerId='" + customerId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<CartItem> listOfCartItems = query.getResultList();
		return listOfCartItems;
	}


}
