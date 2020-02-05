package com.example.webstarter.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.webstarter.model.Order;
import com.example.webstarter.model.OrderProduct;
import com.example.webstarter.model.Product;

@Repository
public interface OrderProductRepository extends CrudRepository<OrderProduct, Integer> {	
	@Transactional
	void deleteByOrder(Order order);
	
	@Transactional
	void deleteByProduct(Product product);
	
	@Transactional
	List<OrderProduct> findByOrderId(Integer id);
}
