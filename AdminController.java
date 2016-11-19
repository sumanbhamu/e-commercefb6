package com.suman.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.suman.ecom.dao.CategoryDAO;
import com.suman.ecom.dao.ProductDAO;
import com.suman.ecom.dao.SupplierDAO;
import com.suman.ecom.model.Category;
import com.suman.ecom.model.Product;
import com.suman.ecom.model.Supplier;


@Controller

public class AdminController {

	@Autowired
	ProductDAO productDAO;

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	Category category;

	@Autowired
	SupplierDAO supplierDAO;

	/*
	 * @Autowired Supplier supplier;
	 */

	@RequestMapping("/adminhome")
	public String ShowAdminHome() {
		return "adminhome";
	}

	@RequestMapping("/addproduct")
	public String ShowAddProduct() {
		return "addproduct";
	}

	@RequestMapping("/addcategory")
	public String ShowAddCategory() {
		return "addcategory";
	}

	@RequestMapping("/addsupplier")
	public String ShowAddSupplier() {
		return "addsupplier";
	}

	//Creates empty  obj and takes values frm user 
	@ModelAttribute
	public Product returnObject() {
		return new Product();

	}

	@ModelAttribute
	public Category returnObject1() {
		return new Category();

	}

	@ModelAttribute
	public Supplier returnObject2() {
		return new Supplier();

	}

	@RequestMapping(value = "/addprod", method = RequestMethod.POST)
	public String ShowAddProduct(@Valid @ModelAttribute("product") Product product, Model model, BindingResult result,
			HttpServletRequest request) throws IOException {
		System.out.println(product.getProd_name());
		System.out.println("image uploaded");
		System.out.println("myproduct controller called");
		MultipartFile image = product.getImg();
		Path path;// belong to nio package
		path = Paths.get("E:/E-Commerce/frontend/src/main/webapp/resources/images/" + product.getProd_name() + ".jpg");
		System.out.println("Path=" + path);
		System.out.println("File name" + product.getImg().getOriginalFilename());
		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(path.toString()));
				System.out.println("Image Saved in:" + path.toString());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Image not saved");

			}
		}
		productDAO.savOrUpdate(product);

		return "viewproducts";
	}
	/*//////////////////////////////////////////////////19-11-16
	*/
	String setName;
	List<Product> plist;
	
	@RequestMapping("GsonCon")
	//@ResponseBody is used whenever angularjs is used
	//for filtering and sorting -angular js
	//(google)gson converts java obj into json(java script obj)
	public @ResponseBody String getValues() throws Exception{
		String result="";
		plist=productDAO.list();
		Gson gson=new Gson();
		result=gson.toJson(plist);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	@RequestMapping(value = "/addcat", method = RequestMethod.POST)
	public String addCate(@ModelAttribute("category") Category category, BindingResult result,
			HttpServletRequest request) {
		categoryDAO.save(category);
		return "viewproducts";

	}

	@RequestMapping(value = "/addsup", method = RequestMethod.POST)
	public String addSupp(@ModelAttribute("supplier") Supplier supplier, BindingResult result,
			HttpServletRequest request) {
		supplierDAO.savOrUpdate(supplier);
		return "viewproducts";

	}

	/*
	 * ////////////////////////////////////////////////////////////
	 */

	@RequestMapping("/viewdetails")
	public String ShowViewDetails() {
		return "viewdetails";
	}

}
