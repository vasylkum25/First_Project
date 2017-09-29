package kum.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kum.model.request.MealRequest;
import kum.model.view.MealView;

public interface MealService{
		
	List<MealView> findAllViews();
	
	Page<MealView> findAllViews(Pageable pageable);
	
	List<String> findAllCafes();
	
	void save(MealRequest request);
	
	MealRequest findOne(Integer id);
	
	List<String> findAllIngredientsByMealId(Integer id);
	
	void delete(Integer id);

	Page<MealView> findAllMealsByUser(String title, Pageable pageable);

}
