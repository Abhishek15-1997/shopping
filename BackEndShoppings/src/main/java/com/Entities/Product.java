package com.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Product {
	
	@Id
	@GeneratedValue
	private int ProductId;
	private String ProductName;
	private String Pdes;
	
	
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="catId",insertable=false,updatable=false )
	private Category cat;
	
	private int CatId=0	;
	

	public int getCatId() {
		return CatId;
	}

	public void setCatId(int catId) {
		CatId = catId;
	}

	public String getPdes() {
		return Pdes;
	}

	public void setPdes(String pdes) {
		Pdes = pdes;
	}
	

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}
	
	

}
