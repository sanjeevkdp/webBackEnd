package com.niit.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;

public class CategoryDaoTest {
	
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	Category category;
	
	AnnotationConfigApplicationContext context;
	@Before
	public void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		category= (Category) context.getBean("category");
		categoryDao= (CategoryDao) context.getBean("categoryDao");
	}
	@Test
	public void CategorySizeTest()
	{
		int size=categoryDao.list().size();
		assertEquals("user list test case",3, size);
		
	}
	 @Test
	 public void CategoryNameTestCase()
	 {
		 category=categoryDao.get("CAT01");
		 String name=category.getCategory_name();
		 assertEquals("this is expeted out put ","cat", name);
	 }

}
