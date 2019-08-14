package com.Mains;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Daos.CategoryDao;
import com.Daos.ProductDao;
import com.Entities.Category;
import com.Entities.Product;


public class Main1 {
 	
	public static void main(String args[])
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("Spring.xml");
		

//		Category c=new Category();
//		c.setCategoryName("Ball");
//		c.setDes("all types of sports ball");
//	
		
//		Product p=new Product();
//		p.setProductName("tennis ball");
//		p.setPdes("green color");
//		p.setCatId(18);
//		
//		Product p1=new Product();
//		p1.setProductName("duce ball");
//		p1.setPdes("white");
//		p1.setCatId(18);
//		
		
		ProductDao pd=(ProductDao)context.getBean("productDaoImpl", ProductDao.class);
		CategoryDao cd=(CategoryDao)context.getBean("categoryDao", CategoryDao.class);
	    
		//cd.addCategory(c);
//		pd.addProduct(p1);
//		pd.addProduct(p);

		List<Product> pp=pd.viewAllProduct();
		System.out.println("...........");
		
		for (Product pp2 : pp) {
			System.out.println(pp2.getProductName());
		}
		
		List<Category> cc=cd.getAllCategory();		
		for (Category cc2 : cc) {
			System.out.println(cc2.getDes());
		}
		
		//p.setCat(cat);
		
	}
	

}
