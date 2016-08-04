package com.niit.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
@Component
public class Product {
	@Id
	private String product_id;
	@NotEmpty(message="Product name not be empty")
	private String product_name;
	@Min(value=500, message="price Should not less then 500")
	private double unit_price;
	private String description;
	@Min(value=0, message="product Quantity should not be less then zero")
	private int quantity;
	private boolean out_of_stock;
	private String category_id;
	private String supplier_id;
	@Transient
	private MultipartFile imgUrl;
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isOut_of_stock() {
		return out_of_stock;
	}
	public void setOut_of_stock(boolean out_of_stock) {
		this.out_of_stock = out_of_stock;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	public MultipartFile getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(MultipartFile imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Product() {
		this.product_id = "PRO"+UUID.randomUUID().toString().substring(27).toUpperCase();
	}
	

}
