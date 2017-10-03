package kum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kum.model.filter.MealFilter;
import kum.model.view.MealView;

public interface MealViewRepository {

	Page<MealView> findAll(Pageable pageable, MealFilter mealFilter);
}
