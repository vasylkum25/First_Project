package kum.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kum.entity.Table;
import kum.model.request.ReserveRequest;
import kum.model.request.TableRequest;
import kum.repository.TableRepository;
import kum.service.TableService;

@Service
public class TableServiceImpl implements TableService {

	@Autowired
	private TableRepository repository;
	
	@Autowired
	public TableServiceImpl(TableRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<String> findAllCafes() {
		return repository.findAllCafes();
	}
	@Override
	public void delete(Integer id) {
		repository.delete(id);
		
	}
	
	@Override
	public List<Table> findAllTables() {
		return repository.findAllTables();
	}
	
	@Override
	public List<Table> findTablesBycafeId(Integer id) {
		return repository.findTablesBycafeId(id);
	}

	@Override
	public TableRequest findOne(Integer id) {
		Table table = repository.findOneRequest(id);
		TableRequest request = new TableRequest();
		request.setId(table.getId());
		request.setCafe(table.getCafe());
		request.setCountOfPeople(Integer.valueOf(table.getCountOfPeople()));
		request.setIsFree(Boolean.valueOf(table.getIsFree()));
		request.setNumber(table.getNumber());
		return request;
		
	}

	@Override
	public void save(TableRequest request) {
		Table table = new Table();
		table.setId(request.getId());
		System.out.println(request.getId());
		table.setCafe(request.getCafe());
		table.setCountOfPeople(Integer.valueOf(request.getCountOfPeople()));
		table.setIsFree(Boolean.valueOf(request.getIsFree()));
		table.setNumber(request.getNumber());
		repository.save(table);
	}



	@Override
	public Table findOneRequest(Integer id) {
		return repository.findOneRequest(id);
	}

	@Override
	public void saveUserInTable(ReserveRequest reserveRequest, Integer id) {
		Table table =repository.findOne(id);
		table.setIsFree(Boolean.TRUE);
		table.setPhone(reserveRequest.getPhone());
		table.setName(reserveRequest.getName());
		repository.save(table);
		
		
	}

	@Override
	public void deSaveUserInTable(Integer id) {
		Table table =repository.findOne(id);
		table.setIsFree(Boolean.FALSE);
		table.setPhone(null);
		table.setName(null);
		repository.save(table);
		
	}

	@Override
	public Page<Table> findTablesBycafeId(Integer id, Pageable pageable) {
		return repository.findTablesBycafeId(id, pageable);
	}
	
	

}
