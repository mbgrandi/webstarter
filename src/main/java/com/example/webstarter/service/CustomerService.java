package com.example.webstarter.service;

import java.util.List;
import java.util.Optional;

import com.example.webstarter.model.Customer;

public interface CustomerService {
	List<Customer> findAll();
	Optional<Customer> findById(Integer id);
	void deleteById(Integer id);
	void delete(Customer customer);
	void save(Customer customer);
}
