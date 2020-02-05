package com.example.webstarter;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.webstarter.model.Customer;
import com.example.webstarter.model.Order;
import com.example.webstarter.model.OrderProduct;
import com.example.webstarter.model.Product;
import com.example.webstarter.service.CustomerService;
import com.example.webstarter.service.OrderProductService;
import com.example.webstarter.service.OrderService;
import com.example.webstarter.service.ProductService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DummyData implements ApplicationListener<ContextRefreshedEvent> {
	private OrderService orderService;
	private ProductService productService;
	private CustomerService customerService;
	private OrderProductService orderProductService;
	
	private static final Logger log = LogManager.getLogger(DummyData.class);
	
	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@Autowired
	public void setOrderProductService(OrderProductService orderProductService) {
		this.orderProductService = orderProductService;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
    	try {
			loadData();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	//listData();
	}
	
	void listData() {
		log.info("Listing Data....");
		
		Iterable<Order> listOrders = orderService.findAll();
    	listOrders.forEach(System.out::println);
    	
    	Iterable<OrderProduct> listOrderProducts = orderProductService.findAll();
    	listOrderProducts.forEach(System.out::println);
    		 	
    	Iterable<Product> listProducts = productService.findAll();
    	listProducts.forEach(System.out::println);
    	
    	Iterable<Customer> listCustomers = customerService.findAll();
    	listCustomers.forEach(System.out::println);
	}
	
	@Transactional
	void loadData() throws JsonParseException, JsonMappingException, IOException {
		log.info("Loading Data....");
		
		// Json Mapper
		ObjectMapper mapper = new ObjectMapper();
		
		// Customers
		InputStream inputCustomers = DummyData.class.getResourceAsStream("/static/data/customers.json");
		List<Customer> customers = mapper.readValue(inputCustomers, new TypeReference<List<Customer>>(){});
		
		for (Customer customer : customers)
			customerService.save(customer);
		
		// Products
		InputStream inputProducts = DummyData.class.getResourceAsStream("/static/data/products.json");
		List<Product> products = mapper.readValue(inputProducts, new TypeReference<List<Product>>(){});
		
		for (Product product : products)
			productService.save(product);
		
		// Orders
		InputStream inputOrders = DummyData.class.getResourceAsStream("/static/data/orders.json");
		List<Order> orders = mapper.readValue(inputOrders, new TypeReference<List<Order>>(){});
		
		for (Order order : orders)
			orderService.save(order);
		
		// Order Products
		InputStream inputOrderProducts = DummyData.class.getResourceAsStream("/static/data/orderproducts.json");
		List<OrderProduct> orderProducts = mapper.readValue(inputOrderProducts, new TypeReference<List<OrderProduct>>(){});
		
		for (OrderProduct orderProduct : orderProducts)
			orderProductService.save(orderProduct);
		
	}

}
