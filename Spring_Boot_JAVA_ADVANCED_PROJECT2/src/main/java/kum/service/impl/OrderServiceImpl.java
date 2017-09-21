package kum.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kum.entity.Order;
import kum.repository.OrderRepository;
import kum.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	OrderRepository repository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository repository) {
		this.repository=repository;
	}

	@Override
	public void save(Order order) {
		repository.save(order);
		
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	




}
