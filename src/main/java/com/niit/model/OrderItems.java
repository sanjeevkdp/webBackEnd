package com.niit.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class OrderItems implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String orderItems_id;
	private String customerId;
	private String product_id;
	private double totalPrice;
	private int quantity;
	
	public String getOrderItems_id() {
		return orderItems_id;
	}
	public void setOrderItems_id(String orderItems_id) {
		this.orderItems_id = orderItems_id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public OrderItems(){
		this.orderItems_id="ORDIT"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
}
