package com.example.webstarter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.webstarter.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
