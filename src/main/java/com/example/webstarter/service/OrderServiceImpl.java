package com.example.webstarter.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webstarter.model.Order;
import com.example.webstarter.model.OrderProduct;
import com.example.webstarter.repository.OrderProductRepository;
import com.example.webstarter.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	private OrderRepository orderRepository;
	private OrderProductRepository orderProductRepository; 
	
	@Autowired
	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	@Autowired
	public void setOrderProductRepository(OrderProductRepository orderProductRepository) {
		this.orderProductRepository = orderProductRepository;
	}

	@Override
	public List<Order> findAll() {
		List<Order> orders = (List<Order>) this.orderRepository.findAll();
		
		for (Order order : orders) {
			BigDecimal orderTotal = new BigDecimal(0);
			List<OrderProduct> orderProducts = this.orderProductRepository.findByOrderId(order.getId());
			for (OrderProduct orderProduct : orderProducts) {
				orderTotal = orderTotal.add(orderProduct.getProductTotal());
			}
			order.setOrderTotal(orderTotal);
		}
		
		return orders;
	}

	@Override
	public Optional<Order> findById(Integer id) {
		return this.orderRepository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		this.orderRepository.deleteById(id);
	}
	
	@Override
	public void delete(Order order) {
		this.orderRepository.delete(order);
	}

	@Override
	public void save(Order order) {
		this.orderRepository.save(order);
	}
}
