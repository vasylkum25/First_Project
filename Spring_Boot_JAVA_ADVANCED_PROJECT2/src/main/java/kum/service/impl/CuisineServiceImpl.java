package kum.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import kum.entity.Cuisine;
import kum.model.filter.SimpleFilter;
import kum.repository.CuisineRepository;
import kum.service.CuisineService;

@Service
public class CuisineServiceImpl implements CuisineService{

	private final CuisineRepository repository;

	@Autowired
	public CuisineServiceImpl(CuisineRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Cuisine findOne(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<Cuisine> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Cuisine entity) {
		repository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);		
	}

	@Override
	public List<String> findAllCuisines() {
		return repository.findAllCuisines();
	}

	@Override
	public Page<Cuisine> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Page<Cuisine> findAll(Pageable pageable, SimpleFilter filter) {
		return repository.findAll(filter(filter), pageable);
	}
	
	private Specification<Cuisine> filter(SimpleFilter filter){
		return (root, query, cb) -> {
				if(filter.getSearch().isEmpty()) return null;
				return cb.like(root.get("name"), filter.getSearch()+"%");
		};
	}

}
