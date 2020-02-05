package com.example.webstarter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webstarter.model.Order;
import com.example.webstarter.model.OrderProduct;
import com.example.webstarter.model.Product;
import com.example.webstarter.repository.OrderProductRepository;

@Service
public class OrderProductServiceImpl implements OrderProductService {
	private OrderProductRepository orderProductRepository;

	@Autowired
	public void setOrderProductRepository(OrderProductRepository orderProductRepository) {
		this.orderProductRepository = orderProductRepository;
	}

	@Override
	public List<OrderProduct> findAll() {
		return (List<OrderProduct>) this.orderProductRepository.findAll();
	}

	@Override
	public Optional<OrderProduct> findById(Integer id) {
		return this.orderProductRepository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		this.orderProductRepository.deleteById(id);
	}

	@Override
	public void deleteByOrder(Order order) {
		this.orderProductRepository.deleteByOrder(order);
	}

	@Override
	public void deleteByProduct(Product product) {
		this.orderProductRepository.deleteByProduct(product);
	}
	
	@Override
	public void save(OrderProduct orderProduct) {
		this.orderProductRepository.save(orderProduct);
	}

	@Override
	public List<OrderProduct> findByOrderId(Integer id) {
		return this.orderProductRepository.findByOrderId(id);
	}

}
