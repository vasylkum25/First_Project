package kum.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import kum.entity.Meal;
import kum.model.view.CafeIndexView;
import kum.model.view.MealView;

public interface MealRepository extends JpaRepository<Meal, Integer>, JpaSpecificationExecutor<MealView> {

	
	@Query("SELECT ca.name FROM Cafe ca")
	List<String> findAllCafe();
	
	@Query("SELECT new kum.model.view.MealView(m.id, m.title, m.description, m.price, m.photoUrl, m.version, c.name, m.weight) FROM Meal m LEFT JOIN m.cuisine c")
	List<MealView> findAllViews();
	
	@Query(value="SELECT new kum.model.view.MealView(m.id, m.title, m.description, m.price, m.photoUrl, m.version, c.name, m.weight) FROM Meal m LEFT JOIN m.cuisine c",
		countQuery="SELECT count(m.id) FROM Meal m LEFT JOIN m.cuisine c")
	Page<MealView> findAllViews(Pageable pageable);
	
	@Query("SELECT i.name FROM Ingredient i JOIN i.meals m WHERE m.id=?1")
	List<String> findAllIngredientsByMealId(Integer id);

	@Query("SELECT DISTINCT m FROM Meal m JOIN FETCH m.cuisine JOIN FETCH m.cafe LEFT JOIN FETCH m.ingredients WHERE m.id=?1")
	Meal findOneReqeust(Integer id);
	
	@Query("SELECT new kum.model.view.CafeIndexView(c.id, c.rate, c.name, c.photoUrl, c.address, c.shortDescription, c.type) FROM Meal m JOIN m.cafe c WHERE m.id=?1")
	CafeIndexView findCafeByMealId(Integer id);

	@Query(value="SELECT new kum.model.view.MealView(m.id, m.title, m.description, m.price, m.photoUrl, m.version, c.name, m.weight) FROM Meal m LEFT JOIN m.cuisine c LEFT JOIN m.cafe ca JOIN ca.user u WHERE u.email=?1",
			countQuery="SELECT count(m.id) FROM Meal m LEFT JOIN m.cuisine c LEFT JOIN m.cafe ca JOIN ca.user u WHERE u.email=?1")
	Page<MealView> findAllMealsBeUser(String title, Pageable pageable);
	
	@Query(value="SELECT new kum.model.view.MealView(m.id, m.title, m.description, m.price, m.photoUrl, m.version, c.name, m.weight) FROM Meal m LEFT JOIN m.cuisine c LEFT JOIN m.cafe ca WHERE ca.id=?1",
			countQuery="SELECT count(m.id) FROM Meal m LEFT JOIN m.cuisine c LEFT JOIN m.cafe ca WHERE ca.id=?1")
	Page<MealView> findAllMealsByCafeId(Integer id, Pageable pageable);
	
//	@Query("SELECT new kum.model.view.MealView(m.id, m.title, m.description, m.price, m.photoUrl, m.version, c.name, m.weight) FROM Meal m JOIN m.order o WHERE o.id=?1")
//	List<MealView> findAllViewsByOrderId(Integer id);
}
