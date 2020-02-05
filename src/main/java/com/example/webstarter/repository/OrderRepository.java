package com.example.webstarter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.webstarter.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
