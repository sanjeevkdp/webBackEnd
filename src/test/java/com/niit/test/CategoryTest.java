package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;

public class CategoryTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
	Category category = (Category) context.getBean("category");
	
	CategoryDao categoryDao = (CategoryDao) context.getBean("categoryDao");
		category.setCategory_id("CAT006");
		category.setCategory_name("Lenoveo");
		category.setDescription("new int the market");

		categoryDao.saveOrUpdate(category);

	}
}
