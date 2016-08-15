package com.niit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Users;
@Repository("usersDao")
public class UsersDaoImpl implements UsersDao {

	@Autowired
	private SessionFactory sessionFactory;

public UsersDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

@Transactional
	public void saveOrUpdate(Users users) {
		sessionFactory.getCurrentSession().saveOrUpdate(users);

	}

@Transactional
public void editUsers(Users users) {
	sessionFactory.getCurrentSession().saveOrUpdate(users);

}

@Transactional
	public void delete(String user_id) {
		Users usersToDelete = new Users();
		usersToDelete.setUser_id(user_id);
		sessionFactory.getCurrentSession().delete(usersToDelete);

	}

@Transactional
	public Users get(String user_id) {

		// sessionFactory.getCurrentSession().get(Users.class,user_id);
		String hql = "from Users where user_id=" + "'" + user_id + "'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<Users> listUsers= (List<Users>) query.getResultList();
		if (listUsers!= null && !listUsers.isEmpty()) {
			return listUsers.get(0);
		}
		return null;
	}

@Transactional
	public List<Users> list() {
		@SuppressWarnings("unchecked")
		List<Users> listUsers= (List<Users>) sessionFactory.getCurrentSession()
		.createCriteria(Users.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUsers;
	}

@Override
public Users getUsersByUserName(String userName) {
	// TODO Auto-generated method stub
	return null;
}


}
