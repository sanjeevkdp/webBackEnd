package com.niit.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart {
	private String cart_id;
	private Map<String, CartItem> cartItems;
	private double grandTotal;
	
	private Cart(){
		cartItems=new HashMap<String,CartItem>();
		grandTotal=0;
	}
	
	public Cart(String cart_id){
		this.cart_id=cart_id;
	}

	public String getCart_id() {
		return cart_id;
	}

	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}

	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	 public void addCartItem(CartItem item){
		 String product_id=item.getProduct().getProduct_id();
		 if(cartItems.containsKey(product_id)){
			 CartItem existiCartItem=cartItems.get(product_id);
			 existiCartItem.setQuantity(existiCartItem.getQuantity()+item.getQuantity());
			 cartItems.put(product_id, existiCartItem);
			 
		 }
		 else{
			 cartItems.put(product_id, item);
		 }
		 updateGrandTotal();
		 
	 }
	 public void deleteCartItem(CartItem item){
		 String product_id=item.getProduct().getProduct_id();
		 cartItems.remove(product_id);
		 updateGrandTotal();
	 }

	public void updateGrandTotal() {
		// TODO Auto-generated method stub
		grandTotal=0;
		for(CartItem item:cartItems.values()){
			grandTotal=grandTotal+item.getTotalPrice();
		}
			}
	

}
