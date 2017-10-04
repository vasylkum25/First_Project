package kum.repository;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kum.model.filter.MealFilter;
import kum.model.view.MealView;

public interface OwnMealViewRepository {

	Page<MealView> findAll(Pageable pageable, MealFilter mealFilter, Principal principal); 
	
}
