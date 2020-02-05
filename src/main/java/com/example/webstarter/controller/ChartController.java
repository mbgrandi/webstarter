package com.example.webstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.webstarter.General;
import com.example.webstarter.model.Chart;
import com.example.webstarter.model.Order;
import com.example.webstarter.service.OrderService;

@RestController
public class ChartController {
	private OrderService orderService;
	
	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@RequestMapping(value = "/chart/orders-total", method = RequestMethod.GET)
	public Chart findAllOrders(@RequestParam(value = "year", defaultValue = "") String year) {
		Integer chartYear;
		if (year.equals(""))
			chartYear = General.CURRENT_YEAR;
		else {
			if (General.isNumeric(year))
				chartYear = Integer.valueOf(year);
			else
				chartYear = 0;
		}
		List<Order> orders = this.orderService.findAll();
		Chart chart = General.buildChartMonths(orders, chartYear);
		return chart;
	}
}
