package com.example.webstarter.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.webstarter.model.Product;
import com.example.webstarter.service.ProductService;

@Controller
public class ProductController {
	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String findAllProducts(Model model) {
		model.addAttribute("products", productService.findAll());
		return "products";
	}
	
	@RequestMapping("product/{id}")
    public String findProductById(@PathVariable Integer id, Model model){
		Optional<Product> product = productService.findById(id);
		if (product.isPresent()) {
			model.addAttribute("product", product.get());
		}
        return "product_view";
    }
}
