package kum.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kum.entity.Table;
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
	public TableRequest findOne(Integer id) {
		Table table = repository.findOneRequest(id);
		TableRequest request = new TableRequest();
		request.setId(table.getId());
		request.setCafe(table.getCafe());
		request.setCountOfPeople(Integer.valueOf(table.getCountOfPeople()));
		request.setIsFree(Boolean.valueOf(table.getIsFree()));
		return request;
		
	}

	@Override
	public void save(TableRequest request) {
		Table table = new Table();
		table.setId(request.getId());
		table.setCafe(request.getCafe());
		table.setCountOfPeople(Integer.valueOf(request.getCountOfPeople()));
		table.setIsFree(Boolean.valueOf(request.getIsFree()));
		repository.save(table);
		
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
		
	}

	@Override
	public List<Table> findAllTables() {
		return repository.findAllTables();
	} 

}
