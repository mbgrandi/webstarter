package com.example.webstarter.service;

import java.util.List;
import java.util.Optional;

import com.example.webstarter.model.Product;

public interface ProductService {
	List<Product> findAll();
	Optional<Product> findById(Integer id);
	void deleteById(Integer id);
	void delete(Product product);
	void save(Product product);
}
