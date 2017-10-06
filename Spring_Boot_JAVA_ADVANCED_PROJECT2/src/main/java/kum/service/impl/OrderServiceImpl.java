package kum.service.impl;



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
	public Page<MealView> saveTableInOrder(String title, Pageable pageable, Integer idTable) {
		Order order = new Order();
//		List<MealView> meals =new ArrayList<>();
//		meals.add(mealRepository.findOne(idMeal));
		order.setTable(tableRepository.findOne(idTable));
		repository.save(order);
		return mealService.findAllMealsByUser(title, pageable);
	}

//	@Override
//	@Transactional(readOnly = true)
//	public List<Order> findAll() {
//		List<Order> orders = repository.findAll();
//		orders.forEach(this::loadMeals);
//		return orders;
//	}

	@Override
	public void saveMealInOrder(Integer idTable, Integer idMeal) {
		Order order = repository.findOrderByTableId(idTable);
		order.getMeals().add(mealRepository.findOne(idMeal));
		repository.save(order);
		
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Meal> findMealByTableId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	@Transactional(readOnly = true)
//	public List<MealView> findAllViews() {
//		List<MealView> views = repository.findAllViews();
//		views.forEach(this::loadIngredients);
//		views.forEach(this::loadCafe);
//		
//		return views;
//	}

//	private void loadMeals(Order order) {
//		order.setMeals(mealRepository.);
//	}

//	private void loadMeal(Order order) {
//		view.setCafe((repository.f);
//	}
//	




}
