//package com.niit.dao;
//
//
//	import java.util.List;
//
//	import org.hibernate.Criteria;
//	import org.hibernate.SessionFactory;
//	import org.hibernate.query.Query;
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.stereotype.Repository;
//	import org.springframework.transaction.annotation.Transactional;
//
//import com.niit.model.UserDetails;
//
//	@Repository("userDetailsDao")
//	public class UserDetailsDaoImpl  implements UserDetailsDao {
//		@Autowired
//		private SessionFactory sessionFactory;
//
//		public UserDetailsDaoImpl(SessionFactory sessionFactory) {
//				this.sessionFactory = sessionFactory;
//
//			}
//
//		@Transactional
//			public void saveOrUpdate(UserDetails userDetails) {
//				sessionFactory.getCurrentSession().saveOrUpdate(userDetails);
//
//			}
//
//		@Transactional
//			public void delete(String id) {
//			UserDetails userDetailsToDelete = new UserDetails();
//			userDetailsToDelete.setUser_id(id);
//				sessionFactory.getCurrentSession().delete(userDetailsToDelete);
//
//			}
//
//		@Transactional
//			public UserDetails get(String id) {
//
//				// sessionFactory.getCurrentSession().get(UserDetails.class,id);
//				String hql = "from UserDetails where Id=" + "'" + id + "'";
//				Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
//				List<UserDetails> listuserDetails = (List<UserDetails>) query.getResultList();
//				if (listuserDetails  != null && !listuserDetails .isEmpty()) {
//					return listuserDetails.get(0);
//				}
//				return null;
//			}
//
//		@Transactional
//			public List<UserDetails> list() {
//				@SuppressWarnings("unchecked")
//				List<UserDetails> listuserDetails= (List<UserDetails>) sessionFactory.getCurrentSession()
//				.createCriteria(UserDetails.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
//				return listuserDetails;
//			}
//
//	}
//
