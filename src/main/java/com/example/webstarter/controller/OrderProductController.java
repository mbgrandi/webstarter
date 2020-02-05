package com.example.webstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.webstarter.model.OrderProduct;
import com.example.webstarter.service.OrderProductService;

@Controller
public class OrderProductController {
	private OrderProductService orderProductService;

	@Autowired
	public void setOrderProductService(OrderProductService orderProductService) {
		this.orderProductService = orderProductService;
	}
	
	@RequestMapping(value = "/orderproducts", method = RequestMethod.GET)
	public String findAllOrderProducts(Model model) {
		model.addAttribute("orderProducts", orderProductService.findAll());
		return "orderproducts";
	}
	
	@RequestMapping("/orderproducts/order/{id}")
    public String findOrderProductsByOrderId(@PathVariable Integer id, Model model){
		if (id != null) {
			List<OrderProduct> orderProducts = orderProductService.findByOrderId(id);
			if (orderProducts.size() > 0) {
				String orderNumber = orderProducts.get(0).getOrder().getOrderNumber();
				model.addAttribute("orderNumber", orderNumber);
			}
			model.addAttribute("orderProducts", orderProducts);
		}
		return "orderproducts"; 
    }
}
