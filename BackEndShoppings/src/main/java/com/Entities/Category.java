package com.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Category {
	
	@Id
	@GeneratedValue
	private int CategoryId;
	private String CategoryName;
	private String des;
	
	@OneToMany(mappedBy="cat")
	private Set<Product> pro=new HashSet<Product>();
	
	
	public Set<Product> getPro() {
		return pro;
	}
	public void setPro(Set<Product> pro) {
		this.pro = pro;
	}
	
	
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	
	

}
