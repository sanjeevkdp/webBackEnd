package com.niit.model;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Customer {
	@Id
    private String customerId;
	@NotBlank(message="name should not be empty")
	private String customer_name;
	@Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
	private String emailAddress;
	@NotBlank(message="phone number should not be empty")
	@Pattern(regexp="(^$|[0-9]{10})")
	private String phoneNo;
	@NotBlank
	private String gender;
	@NotBlank(message="password should not be empty")
	private String password;
	@NotBlank(message="userName should not be empty")
	private String userName;
	private boolean enabled;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Customer(){
		this.customerId="CUST"+UUID.randomUUID().toString().substring(27).toUpperCase();
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	

	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
}
