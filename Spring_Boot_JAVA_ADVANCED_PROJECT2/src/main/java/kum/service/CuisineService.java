package kum.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kum.entity.Cuisine;
import kum.model.filter.SimpleFilter;

public interface CuisineService extends CrudService<Cuisine, Integer>{

	List<String> findAllCuisines();
	
	Page<Cuisine> findAll(Pageable pageable);

	Page<Cuisine> findAll(Pageable pageable, SimpleFilter filter);
}
