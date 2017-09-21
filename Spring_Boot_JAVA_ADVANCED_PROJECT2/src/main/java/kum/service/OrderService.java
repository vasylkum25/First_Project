package kum.service;

import kum.entity.Order;

public interface OrderService {

	void save(Order order);
	
	void delete(Integer id);
	
}
