package com.niit.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart {
	@Id
	private String cart_id;
	private double grandTotal;
	private int noOfproduct;
	private String customerId;
	public String getCart_id() {
		return cart_id;
	}
	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}
	
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getNoOfproduct() {
		return noOfproduct;
	}
	public void setNoOfproduct(int noOfproduct) {
		this.noOfproduct = noOfproduct;
	}
	public Cart() {
		
		this.cart_id = "CRT"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
}
