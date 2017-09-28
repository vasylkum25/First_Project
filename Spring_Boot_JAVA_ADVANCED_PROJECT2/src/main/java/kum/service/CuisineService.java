package kum.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kum.entity.Cuisine;

public interface CuisineService extends CrudService<Cuisine, Integer>{

	List<String> findAllCuisines();
	
	Page<Cuisine> findAll( Pageable pageable);
}
