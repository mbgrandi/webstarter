package com.example.webstarter.service;

import java.util.List;
import java.util.Optional;

import com.example.webstarter.model.Order;

public interface OrderService {
	List<Order> findAll();
	Optional<Order> findById(Integer id);
	void deleteById(Integer id);
	void delete(Order order);
	void save(Order order);
}
