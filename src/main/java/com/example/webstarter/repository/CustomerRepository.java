package com.example.webstarter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.webstarter.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
