package com.example.webstarter.service;

import java.util.List;
import java.util.Optional;

import com.example.webstarter.model.Order;
import com.example.webstarter.model.OrderProduct;
import com.example.webstarter.model.Product;

public interface OrderProductService {
	List<OrderProduct> findAll();
	Optional<OrderProduct> findById(Integer id);
	List<OrderProduct> findByOrderId(Integer id);
	void deleteById(Integer id);
	void deleteByOrder(Order order);
	void deleteByProduct(Product product);
	void save(OrderProduct orderProduct);
}
