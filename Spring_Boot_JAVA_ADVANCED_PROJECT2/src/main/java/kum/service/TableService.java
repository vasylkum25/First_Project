package kum.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kum.entity.Table;
import kum.model.request.ReserveRequest;
import kum.model.request.TableRequest;

public interface TableService{

	List<String> findAllCafes();
	
	List<Table> findAllTables();
	
	void save(TableRequest request);
	
	void saveUserInTable(ReserveRequest request, Integer id);
	
	void deSaveUserInTable(Integer id);
	
	TableRequest findOne(Integer id);
	
	void delete(Integer id);

	List<Table> findTablesBycafeId(Integer id);
	
	Page<Table> findTablesBycafeId(Integer id, Pageable pageable);
	
	Table findOneRequest(Integer id);
	
	

}
