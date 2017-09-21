package kum.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kum.entity.Cuisine;
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
	
	
	
	

	

}
