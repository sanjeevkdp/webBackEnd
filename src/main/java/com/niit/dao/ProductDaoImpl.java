package com.niit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Product;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	public ProductDaoImpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;

		}

	@Transactional
		public void saveOrUpdate(Product product) {
			sessionFactory.getCurrentSession().saveOrUpdate(product);

		}

	@Transactional
		public void editProduct(Product product) {
			sessionFactory.getCurrentSession().saveOrUpdate(product);

		}

	@Transactional
		public void delete(String id) {
		Product proToDelete = new Product();
			proToDelete.setProduct_id(id);
			sessionFactory.getCurrentSession().delete(proToDelete);

		}

	@Transactional
		public Product get(String id) {

			// sessionFactory.getCurrentSession().get(Product.class,id);
			String hql = "from Product where product_id=" + "'" + id + "'";
			Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
			List<Product> listProduct = (List<Product>) query.getResultList();
			if (listProduct  != null && !listProduct .isEmpty()) {
				return listProduct .get(0);
			}
			return null;
		}

	@Transactional
		public List<Product> list() {
			@SuppressWarnings("unchecked")
			List<Product> listProduct  = (List<Product>) sessionFactory.getCurrentSession()
			.createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listProduct;
		}
	@Transactional
	public List<Product> similarProducts(String product_id) {
		Product product = get(product_id);
			
		String hql = "from Product where product_id!=" + "'" + product_id + "'" + "and" + " category_id=" + "'"
				+ product.getCategory_id() + "'" + "and supplier_id!=" + "'" + product.getSupplier_id() + "'"+"and out_of_stock=" + "'" + false + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> similarProductList = query.getResultList();
		return similarProductList;

	}

}
