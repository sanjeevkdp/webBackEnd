package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDao;
import com.niit.model.Supplier;

public class SupplierTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		Supplier supplier = (Supplier) context.getBean("supplier");

		SupplierDao supplierDao = (SupplierDao) context.getBean("supplierDao");
		supplier.setSupplier_id("21");
		supplier.setSupplier_name("parul");
		supplier.setSupplier_contact("9123456780");
		supplier.setSupplier_address("thane");
		supplier.setSupplier_email("parul@gmail.com");
		supplier.setSupplier_imgUrl("default.jpeg");
		

		supplierDao.saveOrUpdate(supplier);

	}

}
