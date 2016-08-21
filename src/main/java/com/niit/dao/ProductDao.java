package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDao {
	void saveOrUpdate(Product product);
	
	void editProduct(Product product);

	void delete(String id);

	Product get(String id);

	List<Product> list();
	
	List<Product> similarProducts(String product_id);
    
	List<Product> productItems(String keyword);
}
