package kum.service;

import java.util.List;

import kum.model.request.MealRequest;
import kum.model.view.MealView;

public interface MealService{
		
	List<MealView> findAllViews();
	
	List<String> findAllCafes();
	
	void save(MealRequest request);
	
	MealRequest findOne(Integer id);
	
	List<String> findAllIngredientsByMealId(Integer id);
	
	void delete(Integer id);

	List<MealView> findAllMealsByUser(String title);

}
