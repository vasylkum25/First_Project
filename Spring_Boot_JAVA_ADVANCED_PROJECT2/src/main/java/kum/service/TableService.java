package kum.service;

import java.util.List;

import kum.entity.Table;
import kum.model.request.TableRequest;

public interface TableService{

	List<String> findAllCafes();
	
	List<Table> findAllTables();
	
	void save(TableRequest request);
	
	TableRequest findOne(Integer id);
	
	void delete(Integer id);
}
