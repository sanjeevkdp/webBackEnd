package com.niit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
		private SessionFactory sessionFactory;

	public CategoryDaoImpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;

		}

	@Transactional
		public void saveOrUpdate(Category category) {
			sessionFactory.getCurrentSession().saveOrUpdate(category);

		}

	@Transactional
	public void editCategory(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);

	}

	@Transactional
		public void delete(String category_id) {
			Category catToDelete = new Category();
			catToDelete.setCategory_id(category_id);
			sessionFactory.getCurrentSession().delete(catToDelete);

		}

	@Transactional
		public Category get(String category_id) {

			// sessionFactory.getCurrentSession().get(Category.class,category_id);
			String hql = "from Category where category_id=" + "'" + category_id + "'";
			Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
			List<Category> listcategory = (List<Category>) query.getResultList();
			if (listcategory != null && !listcategory.isEmpty()) {
				return listcategory.get(0);
			}
			return null;
		}

	@Transactional
		public List<Category> list() {
			@SuppressWarnings("unchecked")
			List<Category> listcategory = (List<Category>) sessionFactory.getCurrentSession()
			.createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listcategory;
		}


}
