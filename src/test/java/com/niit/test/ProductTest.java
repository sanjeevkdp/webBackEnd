package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDao;
import com.niit.model.Product;

public class ProductTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
	Product product = (Product) context.getBean("product");
	
	ProductDao productDao = (ProductDao) context.getBean("productDao");
	    product.setProduct_id("PRD003");
		product.setProduct_name("xolo");
		product.setUnit_price(6778);
		product.setDescription("this is the best product in the market");
		product.setQuantity(3);
		product.setOut_of_stock(false);
		product.setCategory_id("CAT004");
		product.setSupplier_id("21");
		
		productDao.saveOrUpdate(product);

}
}
