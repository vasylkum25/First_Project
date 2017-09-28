package kum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import kum.entity.Ingredient;

public interface IngredientRepository extends JpaNameRepository<Ingredient>{
	
	@Query("SELECT ingredient.name FROM Ingredient ingredient")
	List<String> findAllIngredients();

}
