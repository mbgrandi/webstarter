package com.example.webstarter.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.webstarter.model.Order;
import com.example.webstarter.service.OrderService;

@Controller
public class OrderController {
	private OrderService orderService;

	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String findAllOrders(Model model) {
		model.addAttribute("orders", orderService.findAll());
		return "orders";
	}
	
	@RequestMapping("order/{id}")
    public String findOrderById(@PathVariable Integer id, Model model){
		Optional<Order> order = orderService.findById(id);
		if (order.isPresent()) {
			model.addAttribute("order", order.get());
		}
        return "order_view";
    }
}
