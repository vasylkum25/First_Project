package kum.repository.impl;

import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import kum.entity.Cafe_;
import kum.entity.Cuisine_;
import kum.entity.Meal;
import kum.entity.Meal_;
import kum.model.filter.MealFilter;
import kum.model.view.MealView;
import kum.repository.OwnMealViewRepository;

@Repository
public class OwnMealViewRepositoryImpl implements OwnMealViewRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Page<MealView> findAll(Pageable pageable, MealFilter mealFilter, Principal principal) {
		CriteriaBuilder criteriaBuilder= em.getCriteriaBuilder();
		CriteriaQuery<MealView> cq = criteriaBuilder.createQuery(MealView.class);
		Root<Meal> root  = cq.from(Meal.class);
		cq.multiselect(root.get(Meal_.id), root.get("title"), root.get("description"), root.get("price"), root.get("photoUrl"), root.get("version"), root.get("cuisine"), root.get("weight"), root.get("cafe"));
//		Integer id, String title, String description, BigDecimal price, String photoUrl, int version, String cuisine, int weight
		PredicateBuilder builder = new PredicateBuilder(mealFilter, criteriaBuilder, root, principal);
		Predicate predicate = builder.toPredicate();
		if(predicate!=null) cq.where(predicate);
		cq.orderBy(toOrders(pageable.getSort(), root, criteriaBuilder));
		List<MealView> content = em.createQuery(cq)
				.setFirstResult(pageable.getPageNumber())
				.setMaxResults(pageable.getPageSize())
				.getResultList();
		CriteriaQuery<Long> cqCount = criteriaBuilder.createQuery(Long.class);
		Root<Meal> rootCount = cqCount.from(Meal.class);
		cqCount.select(criteriaBuilder.count(rootCount));
		PredicateBuilder builderCount = new PredicateBuilder(mealFilter, criteriaBuilder, rootCount, principal);
		Predicate predicateCount = builderCount.toPredicate();
		if(predicateCount!=null) cqCount.where(predicateCount);
		return PageableExecutionUtils.getPage(content, pageable, ()->em.createQuery(cqCount).getSingleResult());
	}


	
	
	private static class PredicateBuilder{
		
		final Principal principal;
		
		final MealFilter mealFilter;
		
		final CriteriaBuilder criteriaBuilder;
		
		final Root<Meal> root;
		
		final List<Predicate> predicates = new ArrayList<>();

		public PredicateBuilder(MealFilter mealFilter, CriteriaBuilder criteriaBuilder, Root<Meal> root, Principal principal) {
			this.mealFilter = mealFilter;
			this.criteriaBuilder = criteriaBuilder;
			this.root = root;
			this.principal = principal;
		}
		
		void findByMinPrice(){
		if(!mealFilter.getMinPrice().isEmpty()){
			predicates.add(criteriaBuilder.ge(root.get("price"), new BigDecimal(mealFilter.getMinPrice().replaceAll(",", "."))));
		}	
			
		}
		void findByMaxPrice(){
			if(!mealFilter.getMaxPrice().isEmpty()){
				predicates.add(criteriaBuilder.le(root.get("price"), new BigDecimal(mealFilter.getMaxPrice().replaceAll(",", "."))));
			}
		}
		
		void findByTitle(){
			if(!mealFilter.getSearch().isEmpty()){
				predicates.add(criteriaBuilder.like(root.get("title"), mealFilter.getSearch()+"%"));
			}
		}
		void findByCafe(){
			if(!mealFilter.getCafeId().isEmpty()){
				predicates.add(root.get(Meal_.cafe).get(Cafe_.id).in(mealFilter.getCafeId()));
			}
		}
		
		void findByCuisine(){
			if(!mealFilter.getCuisineId().isEmpty()){
				predicates.add(root.get(Meal_.cuisine).get(Cuisine_.id).in(mealFilter.getCuisineId()));
			}
		}
			
		void findOwnMeals(Principal principal){
			predicates.add(criteriaBuilder.equal(root.get(Meal_.cafe).get(Cafe_.user).get("email"), principal.getName()));
		}
		
		Predicate toPredicate(){
			findByMinPrice();
			findByMaxPrice();
			findByTitle();
			findByCafe();
			findByCuisine();
//			System.out.println(criteriaBuilder.equal(root.get(Meal_.cafe).get(Cafe_.user).get("email"), principal.getName()));
//			System.out.println(principal.getName());
			findOwnMeals(principal);
			return  criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		} 
		
	}
}







