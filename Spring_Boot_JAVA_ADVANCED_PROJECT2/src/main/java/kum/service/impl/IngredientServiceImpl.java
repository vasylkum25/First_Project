package kum.service.impl;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import kum.entity.Ingredient;
import kum.model.filter.SimpleFilter;
import kum.repository.IngredientRepository;
import kum.service.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService {

	@Autowired
	IngredientRepository repository;

	@Override
	public List<String> findAllIngredients() {
		return repository.findAllIngredients();
	}
	
	@Override
	public Ingredient findOne(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public void save(Ingredient entity) {
		repository.save(entity);
		
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);		
	}

	@Override
	public List<Ingredient> findAll() {
		return repository.findAll();
	}

	@Override
	public Page<Ingredient> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Page<Ingredient> findAll(Pageable pageable, SimpleFilter filter) {
		return repository.findAll(filter(filter), pageable);
	}

	public Specification<Ingredient> filter(SimpleFilter filter){
		return (root, cq, cb) -> {
			if(filter.getSearch().isEmpty()) return null;
				return cb.like(root.get("name"), filter.getSearch()+"%");
		};
	}

}
