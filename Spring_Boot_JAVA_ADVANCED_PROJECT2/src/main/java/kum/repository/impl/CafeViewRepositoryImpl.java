package kum.repository.impl;

import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import kum.entity.Cafe;
import kum.entity.Cafe_;
import kum.entity.Meal;
import kum.entity.Meal_;
import kum.model.filter.CafeFilter;
import kum.model.view.CafeIndexView;
import kum.repository.CafeViewRepository;

@Repository
public class CafeViewRepositoryImpl implements CafeViewRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Page<CafeIndexView> findAll(CafeFilter cafeFilter, Pageable pageable) {
		CriteriaBuilder criteriaBuilder= em.getCriteriaBuilder();
		CriteriaQuery<CafeIndexView> cq = criteriaBuilder.createQuery(CafeIndexView.class);
		Root<Cafe> root  = cq.from(Cafe.class);
		cq.multiselect(root.get(Cafe_.id), root.get("rate"), root.get("name"), root.get("photoUrl"), root.get("address"), root.get("shortDescription"), root.get("type"));
		PredicateBuilder builder = new PredicateBuilder(cafeFilter, criteriaBuilder, root);
		Predicate predicate = builder.toPredicate();
		if(predicate!=null) cq.where(predicate);
		cq.orderBy(toOrders(pageable.getSort(), root, criteriaBuilder));
		List<CafeIndexView> content = em.createQuery(cq)
				.setFirstResult(pageable.getPageNumber())
				.setMaxResults(pageable.getPageSize())
				.getResultList();
		CriteriaQuery<Long> cqCount = criteriaBuilder.createQuery(Long.class);
		Root<Cafe> rootCount = cqCount.from(Cafe.class);
		cqCount.select(criteriaBuilder.count(rootCount));
		PredicateBuilder builderCount = new PredicateBuilder(cafeFilter, criteriaBuilder, rootCount);
		Predicate predicateCount = builderCount.toPredicate();
		if(predicateCount!=null) cqCount.where(predicateCount);
		return PageableExecutionUtils.getPage(content, pageable, ()->em.createQuery(cqCount).getSingleResult());
	}

private static class PredicateBuilder{
	
	final CafeFilter cafeFilter;
	
	final CriteriaBuilder criteriaBuilder;
	
	final Root<Cafe> root;
	
	final List<Predicate> predicates = new ArrayList<>();
	
	public PredicateBuilder(CafeFilter cafeFilter, CriteriaBuilder criteriaBuilder, Root<Cafe> root) {
		this.cafeFilter = cafeFilter;
		this.criteriaBuilder = criteriaBuilder;
		this.root = root;
	}
	
	void findByMinRate(){
		if(!cafeFilter.getMinRate().isEmpty()){
			predicates.add(criteriaBuilder.ge(root.get("rate"), new BigDecimal(cafeFilter.getMinRate().replace(",", "."))));
		}
	}

	void findByMaxRate(){
		if(!cafeFilter.getMaxRate().isEmpty()){
			predicates.add(criteriaBuilder.le(root.get("rate"), new BigDecimal(cafeFilter.getMaxRate().replace(",", "."))));
		}
	}
	
	void findByType(){
		if(!cafeFilter.getTypes().isEmpty()){
			predicates.add(root.get("type").in(cafeFilter.getTypes()));
		}
	}
	
	void findByMeals(){
		if(!cafeFilter.getMealsIds().isEmpty()){
			Join<Cafe, Meal> join = root.join(Cafe_.meals);
			predicates.add(join.get(Meal_.id).in(cafeFilter.getMealsIds()));
		}
		
	}
	
	void findByName(){
		if(!cafeFilter.getSearch().isEmpty()){
			predicates.add(criteriaBuilder.like(root.get(Cafe_.name), cafeFilter.getSearch()+"%"));
		}
	}
	
	Predicate toPredicate(){
		findByMinRate();
		findByMaxRate();
		findByType();
		findByMeals();
		findByName();
//		return criteriaBuilder.and(predicates.stream().toArray(Predicate[]::new));
	return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));	
		}
	}
}	
	







