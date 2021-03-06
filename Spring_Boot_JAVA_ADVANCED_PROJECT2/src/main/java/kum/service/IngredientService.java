package kum.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kum.entity.Ingredient;
import kum.model.filter.SimpleFilter;

public interface IngredientService extends CrudService<Ingredient, Integer> {
	
	List<String> findAllIngredients();
	
	Page<Ingredient> findAll(Pageable pageable);

	Page<Ingredient> findAll(Pageable pageable, SimpleFilter filter);
	
}
