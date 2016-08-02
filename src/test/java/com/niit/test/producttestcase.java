package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDao;
import com.niit.model.Product;

public class producttestcase {

	@Autowired
	static Product product;
	@Autowired
	static ProductDao productDao;
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		product = (Product) context.getBean("product");
		productDao = (ProductDao) context.getBean("productDao");
	}

	@Test
	public void productName() {

		String name = product.getProduct_name();
		assertEquals("this is the", "ART", name);

	}

}
