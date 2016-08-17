package com.niit.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.CartItem;
@Repository("cartItemDao")
public class CartItemDaoImpl implements CartItemDao{
	@Autowired
	SessionFactory sessionFactory;

	public CartItemDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(CartItem cartItem) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartItem);

	}

	@Transactional
	public void delete(String cartItemId) {
		CartItem cartItemToDelete = new CartItem();
		cartItemToDelete.setCartItemId(cartItemId);
		sessionFactory.getCurrentSession().delete(cartItemToDelete);
	}

	@Transactional
	public List<CartItem> getCartItemsByCustomerId(String customerId) {
		String hql = "from CartItem where customerId=" + "'" + customerId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<CartItem> listOfCartItems = query.getResultList();
		return listOfCartItems;
	}

	@Transactional
	public List<CartItem> listCartItems() {
		String hql = "from CartItem";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<CartItem> cartItems = query.getResultList();
		return cartItems;

	}

	@Transactional
	public CartItem getCartItem(String cartItemId) {
		String hql = "from CartItem where cartItemId=" + "'" + cartItemId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<CartItem> cartItemList = query.getResultList();
		if(cartItemList!=null && !cartItemList.isEmpty())
			return cartItemList.get(0);
		return null;
	}

}
