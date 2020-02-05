package com.example.webstarter.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.webstarter.model.Customer;
import com.example.webstarter.service.CustomerService;

@Controller
public class CustomerController {
	private CustomerService customerService;

	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String findAllCustomers(Model model) {
		model.addAttribute("customers", customerService.findAll());
		return "customers";
	}
	
	@RequestMapping("/customer/{id}")
    public String findCustomerById(@PathVariable Integer id, Model model){
		Optional<Customer> customer = customerService.findById(id);
		if (customer.isPresent()) {
			model.addAttribute("customer", customer.get());
		}
        return "customer_view";
    }
	
	
}
