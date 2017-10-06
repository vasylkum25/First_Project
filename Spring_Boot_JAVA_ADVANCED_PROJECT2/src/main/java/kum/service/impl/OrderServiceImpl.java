package kum.service.impl;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kum.entity.Meal;
import kum.entity.Order;
import kum.model.view.MealView;
import kum.repository.MealRepository;
import kum.repository.OrderRepository;
import kum.repository.TableRepository;
import kum.service.MealService;
import kum.service.OrderService;
import scala.annotation.meta.setter;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository repository;
	private	MealRepository mealRepository;
	private	TableRepository tableRepository;
	private MealService mealService;
	
	@Autowired
	public OrderServiceImpl(OrderRepository repository, MealRepository mealRepository,
			 MealService mealService, TableRepository tableRepository) {
		this.repository=repository;
		this.mealRepository = mealRepository;
		this.tableRepository = tableRepository;
		this.mealService = mealService;
	}

	@Override
	public void save(Order order) {
		repository.save(order);
		
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	@Override
	public Page<MealView> saveTableInOrder(Pageable pageable, Integer idTable, Integer idCafe) {
		Order order =repository.findOrderByTableId(idTable);
			if(order!=null){
				order.setTable(tableRepository.findOne(idTable));
			}else{
				order = new Order();
				order.setTable(tableRepository.findOne(idTable));
				order.setTotalPrice(BigDecimal.ZERO);
			}
		repository.save(order);
		return mealService.findAllMealsByCafeId(idCafe, pageable);
	}


	@Override
	public void saveMealInOrder(Integer idTable, Integer idMeal) {
		Order order = repository.findOrderByTableId(idTable);
		order.getMeals().add(mealRepository.findOne(idMeal));
		repository.save(order);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Order> findAll() {
		List<Order> orders = repository.findAll();
		orders.forEach(this::loadMeals);
		for (Order order : orders) {
		BigDecimal tot = BigDecimal.ZERO;
		List<Meal>	meals = order.getMeals();
		for (Meal meal : meals) {
			tot =tot.add(meal.getPrice());
								}
		order.setTotalPrice(tot);
		
		}
		return orders;
	}

	private void loadMeals(Order order) {
		order.setMeals(repository.findMealByOrderId(order.getId()));
	}
	

}
