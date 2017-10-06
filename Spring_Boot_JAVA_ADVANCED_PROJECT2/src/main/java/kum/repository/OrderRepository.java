package kum.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kum.entity.Meal;
import kum.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("SELECT o FROM Order o JOIN o.table t WHERE t.id=?1")
	Order findOrderByTableId(Integer id);
	
	@Query("SELECT m.title FROM Order o JOIN o.meals m JOIN o.table t WHERE t.id=?1")
	List<Meal> findMealByTableId(Integer id);
	
}

