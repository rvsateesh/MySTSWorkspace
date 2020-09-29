package com.eval.coronakit.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/home")
	public String home() {
		return null;
	}
	
	@GetMapping("/product-entry")
	public String productEntry(Model model) {
		
		return null;
	}
	
	@PostMapping("/product-save")
	public String productSave(@ModelAttribute ProductMaster product, BindingResult result ) {
		return null;
	}
	

	@GetMapping("/product-list")
	public String productList(Model model) {
		return null;
	}
	
	@GetMapping("/product-delete/{productId}")
	public String productDelete(@PathVariable("productId") int productId) {
		return null;
	}
	
}
