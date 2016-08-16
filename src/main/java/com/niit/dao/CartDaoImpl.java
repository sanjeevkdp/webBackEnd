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
public  class CartDaoImpl implements CartDao{
	@Autowired
	private SessionFactory sessionFactory;
	public CartDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
 @Transactional
 public void saveOrUpdate(Cart cart){
	 sessionFactory.getCurrentSession().saveOrUpdate(cart);
 }
 @Transactional
 public void editCart(Cart cart){
	 sessionFactory.getCurrentSession().saveOrUpdate(cart);
 }
 @Transactional
 public  void delete(String cart_id){
	 Cart cartToDelete=new Cart();
	 cartToDelete.setCart_id(cart_id);
	 sessionFactory.getCurrentSession().delete(cart_id);
	 
 }
 @Transactional
 public Cart get(String cart_id){
	 //sessionFactory.getCurrentSession().get(Cart.class, cart_id);
	 String hql ="from Cart where cart_id="+"'"+cart_id+"'";
	 Query query=(Query) sessionFactory.getCurrentSession().createQuery(hql);
	 List<Cart>listCart=(List<Cart>) query.getResultList();
	 if(listCart !=null && !listCart.isEmpty()){
		 return listCart.get(0);
	 }
	 return null;
 }
 @Transactional
 public List<Cart> list(){
	 String hql = "from Cart";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Cart> listOfCarts = query.getResultList();
		return listOfCarts;
	 
 }
 @Transactional
	public Cart getCartByCustomerId(String customerId) {
		String hql = "from Cart where customerId=" + "'" + customerId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Cart> customerList= query.getResultList();
		if(customerList!=null && !customerList.isEmpty())			
			return customerList.get(0);
		
		return null;
	}

}
