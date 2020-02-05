package com.example.webstarter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webstarter.model.Product;
import com.example.webstarter.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	private ProductRepository productRepository;
	
	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> findAll() {
		return (List<Product>) this.productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(Integer id) {
		return this.productRepository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		this.productRepository.deleteById(id);
	}
	
	@Override
	public void delete(Product product) {
		this.productRepository.delete(product);
	}

	@Override
	public void save(Product product) {
		this.productRepository.save(product);
	}

}
