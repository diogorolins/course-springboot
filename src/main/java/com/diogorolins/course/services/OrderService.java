package com.diogorolins.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogorolins.course.entities.Order;
import com.diogorolins.course.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();		
	}
	
	public Order findById(Long id) {		
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}

}
