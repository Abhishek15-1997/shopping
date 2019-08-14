package com.Daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.Entities.Category;


public interface CategoryDao {

	public boolean addCategory(Category c);
	public Category viewCategory(int id);
	public List<Category> getAllCategory();
	public boolean delCategory(Category c);
	public boolean updateCategory(Category c);
}
