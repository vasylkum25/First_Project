package kum.service;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kum.entity.Meal;
import kum.model.filter.MealFilter;
import kum.model.request.MealRequest;
import kum.model.view.MealView;

public interface MealService{
		
	List<MealView> findAllViews();
	
	List<Meal> findAll();
	
	List<String> findAllCafes();
	
	void save(MealRequest request);
	
	MealRequest findOne(Integer id);
	
	List<String> findAllIngredientsByMealId(Integer id);
	
	void delete(Integer id);

	Page<MealView> findAllViews(Pageable pageable);
	
	Page<MealView> findAllMealsByUser(String title, Pageable pageable);
	
	Page<MealView> findAll(Pageable pageable, MealFilter mealFilter);
	
	Page<MealView> findAllOwnMeal(Pageable pageable, MealFilter mealFilter, Principal principal);
	
}
