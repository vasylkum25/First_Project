package kum.service;

import java.util.List;

import kum.entity.Ingredient;

public interface IngredientService extends CrudService<Ingredient, Integer> {

	List<String> findAllIngredients();
}
