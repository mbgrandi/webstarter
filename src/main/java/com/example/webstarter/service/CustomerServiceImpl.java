package com.example.webstarter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webstarter.model.Customer;
import com.example.webstarter.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository customerRepository;

	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAll() {
		return (List<Customer>) this.customerRepository.findAll();
	}

	@Override
	public Optional<Customer> findById(Integer id) {
		return this.customerRepository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		this.customerRepository.deleteById(id);
	}
	
	@Override
	public void delete(Customer customer) {
		this.customerRepository.delete(customer);
	}

	@Override
	public void save(Customer customer) {
		this.customerRepository.save(customer);
	}

}
