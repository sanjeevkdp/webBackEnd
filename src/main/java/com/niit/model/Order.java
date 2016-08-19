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
public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String order_id;
    private String customerId;
	private double grandTotal;
	private String shippingAddress_id;
	private String billingAddress_id;

	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public String getShippingAddress_id() {
		return shippingAddress_id;
	}
	public void setShippingAddress_id(String shippingAddress_id) {
		this.shippingAddress_id = shippingAddress_id;
	}
	public String getBillingAddress_id() {
		return billingAddress_id;
	}
	public void setBillingAddress_id(String billingAddress_id) {
		this.billingAddress_id = billingAddress_id;
	}

	public Order(){
		this.order_id="ODR"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
}
