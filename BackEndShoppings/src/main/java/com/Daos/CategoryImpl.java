package com.Daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Daos.CategoryDao;
import com.Entities.Category;

@Repository(value="categoryDao")
@Transactional
public class CategoryImpl implements CategoryDao {

	@Autowired
	SessionFactory sf;
	public boolean addCategory(Category c) {
		
		try {
			
			Session session=sf.getCurrentSession();
			//Transaction t=session.beginTransaction();
			session.save(c);
			return true;
			
		}
		catch(Exception e) {e.printStackTrace();}
		
		return false;
	}

	public Category viewCategory(int id) {
	
		try {
		Session session=sf.getCurrentSession();
		Category cat=session.get(Category.class, id);
		
		return cat;
		
		}
		catch(Exception e) {e.printStackTrace();}
		return null;
	}

	public List<Category> getAllCategory() {
		
		try {
			Session session=sf.getCurrentSession();
			Query q=session.createQuery("from Category");
			return q.getResultList();
			
		}
		catch(Exception e) {e.printStackTrace();}
		return null;
	}

	public boolean delCategory(Category c) {
		try {
			Session session=sf.getCurrentSession();
				session.delete(c);
				return true;
			
			}
			catch(Exception e) {e.printStackTrace();}
			
		
		return false;
	}

	public boolean updateCategory(Category c) {
		
		try {
			Session session=sf.getCurrentSession();
			
				session.update(c);
				return true;
			
					
		}
		catch(Exception e) {e.printStackTrace();}
		return false;
	}
}
	


