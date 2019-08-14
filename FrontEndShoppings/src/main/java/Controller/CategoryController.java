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
import com.Entities.Category;



@Controller
public class CategoryController {

	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String gotoHome()
	{
			return "homepage";
	}


	@RequestMapping(value="/form",method=RequestMethod.GET)
	public ModelAndView getCategoryForm(){
		
		ModelAndView mv=new ModelAndView("CategoryForm");
		
		//This is the data we want to share
		mv.addObject("CategoryObj",new Category());
		mv.addObject("btnLabel","Add Category");
		mv.addObject("frmLabel","Add Category Form");
		return mv;
	}
	
	//problems here: A different object with the same identifier value was already associated with the session :
	@RequestMapping(value="addCategory",method=RequestMethod.POST)
	public String addCategory(@ModelAttribute Category cObj,ModelMap map)
	{
		if(cObj.getCategoryId()==0){
			System.out.println("added  ");
			categoryDao.addCategory(cObj);
			map.addAttribute("msg","Category Added Succesfully");
		}
		else {
			//taking the previous value
			categoryDao.updateCategory(cObj);
			System.out.println("updated");
			
		}
		
			return "homepage";
	}
	
	@RequestMapping(value="/viewCat",method=RequestMethod.GET)
	public String ViewCategory(ModelMap map)
	{
		List<Category> categoryList=categoryDao.getAllCategory();
		map.addAttribute("categories",categoryList);
		System.out.println("entered in view");
		return "CategoryView";
	}
	
	@RequestMapping(value="deleteCategory/{cat}",method=RequestMethod.GET)
	public String delCategory(@PathVariable int cat,ModelMap map)
	{
	
		Category c=categoryDao.viewCategory(cat);		
		categoryDao.delCategory(c); 
		
		List<Category> categoryList=categoryDao.getAllCategory();
		map.addAttribute("categories",categoryList);
		return "CategoryView";
	}
	
	@RequestMapping(value="/updateCategory/{catId}",method=RequestMethod.GET)
	public ModelAndView updateCategoryForm(@PathVariable int catId,ModelMap map){
		Category cObj=categoryDao.viewCategory(catId);
		ModelAndView mv=new ModelAndView("CategoryForm");
		mv.addObject("CategoryObj",cObj);
		mv.addObject("btnLabel","Update Category");
		mv.addObject("frmLabel","Update Category Form");
		
		return mv;
		
	
	}


}
