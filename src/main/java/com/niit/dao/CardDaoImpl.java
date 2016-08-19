package com.niit.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Card;
@Repository("cardDao")
public class CardDaoImpl implements CardDao {
	@Autowired
	private SessionFactory sessionFactory;

	public CardDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void saveOrUpdate(Card card) {
	sessionFactory.getCurrentSession().saveOrUpdate(card);

	}
}
