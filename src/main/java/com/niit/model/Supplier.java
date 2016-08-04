package com.niit.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
@Component
public class Supplier {
	@Id
	private String supplier_id;
	private String supplier_name;
	private String supplier_email;
	private String supplier_contact;
	private String supplier_address;
	private String supplier_imgUrl;
	@Transient
	private MultipartFile imgUrl;

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getSupplier_email() {
		return supplier_email;
	}

	public void setSupplier_email(String supplier_email) {
		this.supplier_email = supplier_email;
	}

	public String getSupplier_contact() {
		return supplier_contact;
	}

	public void setSupplier_contact(String supplier_contact) {
		this.supplier_contact = supplier_contact;
	}

	public String getSupplier_address() {
		return supplier_address;
	}

	public void setSupplier_address(String supplier_address) {
		this.supplier_address = supplier_address;
	}

	public String getSupplier_imgUrl() {
		return supplier_imgUrl;
	}

	public void setSupplier_imgUrl(String supplier_imgUrl) {
		this.supplier_imgUrl = supplier_imgUrl;
	}

	public MultipartFile getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(MultipartFile imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Supplier() {

		this.supplier_id = "SUP" + UUID.randomUUID().toString().substring(27).toUpperCase();
	}

}