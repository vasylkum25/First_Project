package kum.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kum.entity.Meal;
import kum.entity.Order;
import kum.model.view.MealView;

public interface OrderService {

	void save(Order order);
	
	void delete(Integer id);
	
	Page<MealView> saveTableInOrder (String title, Pageable pageable, Integer idTable);
	
	List<Order> findAll();
	
	void saveMealInOrder(Integer idTable, Integer idMeal);
	
	List<Meal> findMealByTableId(Integer id);
	
}
