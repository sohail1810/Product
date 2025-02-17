package com.sathya.springMVC.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sathya.springMVC.Entity.ProductEntity;
import com.sathya.springMVC.ProductModel.ProductModel;
import com.sathya.springMVC.Service.ProductService;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;




@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	ProductService productService;
	private ProductService productServive;
	@GetMapping("/productform")
	public String getProductForm(org.springframework.ui.Model model)
	{
		ProductModel productModel=new ProductModel();
		productModel.setMadeIn("USA");
		productModel.setQuantity(2);
		productModel.setDiscountRate(20);
		model.addAttribute("productModel",productModel);
		
		return "add-product";
	}
	@PostMapping("/saveProduct")
	public String saveProductForm(@Valid ProductModel productModel, BindingResult bindingResult,org.springframework.ui.Model model) 
	{
		HashMap<String, String> validationErrors=new HashMap<String, String>();
		if(bindingResult.hasErrors())
		{
			for(FieldError fieldError: bindingResult.getFieldErrors())
			{
				validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			model.addAttribute("validationErrors",validationErrors);
			return "add-product";
		}
		
		productService.saveProductDetails(productModel);
		return "Success";
	}
	@GetMapping("/getallproducts")
	public String getAllProducts(org.springframework.ui.Model model)
	{
		List<ProductEntity> products=productService.getAllProducts();
		model.addAttribute("products", products);
		return "Product-list";
		
		
	}
	@GetMapping("/getsearchform")
	public String searchById() {
		return "Search-Product";
	}
	
	@PostMapping("/searchbyid")
	public String searchById(@RequestParam Long id,org.springframework.ui.Model model)
	{
		ProductEntity products=productService.searchById(id);
		model.addAttribute("products", products);
		
		
		return "Search-Product";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteProductById(@PathVariable ("id") Long id )
	{
		productService.deleteProductById(id);
		return "redirect:/getallproducts";
	}
	@GetMapping("/edit/{id}")
	public String editProductById(@PathVariable ("id") Long id,org.springframework.ui.Model model)
	{
		ProductModel product=productService.editProducts(id);
		model.addAttribute("product",product);
		model.addAttribute("id", id);
		return "Edit-Product";
	}
	@PostMapping("/editproduct/{id}")
	public String editproduct(@PathVariable("id") long id,ProductModel  productModel ) {
		productService.editProducts(id,productModel);
		return "redirect:/getallproducts";
	}
	
	
	
	

}
