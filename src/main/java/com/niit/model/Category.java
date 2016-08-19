package com.niit.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.sun.mail.handlers.multipart_mixed;

@Entity
@Table(name="category")
@Component
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String category_id;
    @NotEmpty(message="Category name not be empty")
	private String category_name;
    @NotEmpty(message="Description should be somthing")
	private String description;
	@Transient 
	private MultipartFile imgUrl;
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public MultipartFile getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(MultipartFile imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public Category() {
		
		this.category_id = "CAT"+UUID.randomUUID().toString().substring(27).toUpperCase();
	}
	

	

}
