package com.niit.dao;

import java.util.List;
import com.niit.model.Category;

public interface CategoryDao {
	void saveOrUpdate(Category category);
	
	void editCategory(Category category);

	void delete(String category_id);

	Category get(String category_id);

	public List<Category> list();

}