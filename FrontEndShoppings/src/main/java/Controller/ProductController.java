package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Daos.CategoryDao;
import com.Daos.ProductDao;
import com.Entities.Category;
import com.Entities.Product;



@Controller
public class ProductController {


	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ProductDao productDaoImpl;
	
	@RequestMapping(value="/pform",method=RequestMethod.GET)
	public ModelAndView getProductForm(){
		System.out.println("aa");
		ModelAndView mv=new ModelAndView("ProductForm");
		
		//This is the data we want to share
		mv.addObject("ProductObj",new Product());
		List<Category> categoryList=categoryDao.getAllCategory();
		mv.addObject("categorylists",categoryList);
		
		return mv;
	}
	
	@RequestMapping(value="addProduct",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute Product ProductObj,ModelMap map)
	{
		//System.out.println(ProductObj.getPdes()+ProductObj.getCid()+"..........");
		
		if(ProductObj.getProductId()==0){
			System.out.println("added  ");
			productDaoImpl.addProduct(ProductObj);
			map.addAttribute("msg","Category Added Succesfully");
		}
		else {
			//taking the previous value
			productDaoImpl.updateProduct(ProductObj);
			System.out.println("updated");
			
		}
	
		
			return "homepage";
	}
	
	@RequestMapping(value="viewP",method=RequestMethod.GET)
	public String ViewProduct(ModelMap map)
	{
		List<Product> productList=productDaoImpl.viewAllProduct();
		map.addAttribute("myproducts",productList);
		
		System.out.println("entered in viewProduct");
		return "ProductView";
	}
	
	@RequestMapping(value="/updateProduct/{catId}",method=RequestMethod.GET)
	public ModelAndView updateProductForm(@PathVariable int catId,ModelMap map){
		Product pObj=productDaoImpl.viewProduct(catId);
		ModelAndView mv=new ModelAndView("ProductForm");
		mv.addObject("ProductObj",pObj);
		mv.addObject("btnLabel","Update Category");
		mv.addObject("frmLabel","Update Category Form");
		
		return mv;
	}

}
