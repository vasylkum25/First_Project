package kum.service;

import java.util.List;

import kum.entity.Cuisine;

public interface CuisineService extends CrudService<Cuisine, Integer>{

	List<String> findAllCuisines();
}
