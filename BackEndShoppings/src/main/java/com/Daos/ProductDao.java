package com.Daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.Entities.Product;


public interface ProductDao {

	public boolean addProduct(Product c);
	public List<Product> viewAllProduct();
	public boolean delProduct(Product c);
	public boolean updateProduct(Product c);
	public Product viewProduct(int id);
}
