package kum.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kum.entity.Meal;
import kum.model.request.MealRequest;
import kum.model.view.MealView;
import kum.repository.MealRepository;
import kum.service.MealService;

@Service
public class MealServiceImpl implements MealService {

	private final MealRepository repository;

	@Autowired
	public MealServiceImpl(MealRepository repository) {
		this.repository = repository;
	}


	@Override
	public List<String> findAllCafes() {
		return repository.findAllCafe();
	}


	@Override
	@Transactional(readOnly = true)
	public List<MealView> findAllViews() {
		List<MealView> views = repository.findAllViews();
		views.forEach(this::loadIngredients);
		views.forEach(this::loadCafe);
		
		return views;
	}

	private void loadIngredients(MealView view) {
		view.setIngredients(repository.findAllIngredientsByMealId(view.getId()));
	}
	
	private void loadCafe(MealView view) {
		view.setCafe(repository.findCafeByMealId(view.getId()));
	}

	

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	@Override
	public void save(MealRequest request) {
		Meal meal = new Meal();
		meal.setCafe(request.getCafe());
		meal.setCuisine(request.getCuisine());
		meal.setDescription(request.getDescription());
		meal.setId(request.getId());
		meal.setIngredients(request.getIngredients());
		meal.setPhotoUrl(request.getPhotoUrl());
		meal.setPrice(new BigDecimal(request.getPrice()));
		meal.setTitle(request.getTitle());
		meal.setVersion(request.getVersion());
		meal.setWeight(Integer.valueOf(request.getWeight()));
		repository.save(meal);
	}

	@Override
	public MealRequest findOne(Integer id) {
		Meal meal = repository.findOneReqeust(id);
		MealRequest request = new MealRequest();
		request.setCafe(meal.getCafe());
		request.setCuisine(meal.getCuisine());
		request.setDescription(meal.getDescription());
		request.setId(meal.getId());
		request.setIngredients(meal.getIngredients());
		request.setPhotoUrl(meal.getPhotoUrl());
		request.setPrice(String.valueOf(meal.getPrice()));
		request.setTitle(meal.getTitle());
		request.setVersion(meal.getVersion());
		request.setWeight(String.valueOf(meal.getWeight()));
		return request;
	}

	@Override
	public List<String> findAllIngredientsByMealId(Integer id) {
		return repository.findAllIngredientsByMealId(id);
	}


	@Override
	@Transactional(readOnly = true)
	public List<MealView> findAllMealsByUser(String title) {
		List<MealView> views = repository.findAllMealsBeUser(title);
		views.forEach(this::loadIngredients);
		views.forEach(this::loadCafe);
		return views;
	}

}
