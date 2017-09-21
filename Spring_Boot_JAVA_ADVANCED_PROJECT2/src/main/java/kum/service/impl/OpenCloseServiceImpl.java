package kum.service.impl;


import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kum.entity.OpenClose;
import kum.repository.OpenCloseRepository;
import kum.service.OpenCloseService;

@Service
public class OpenCloseServiceImpl implements OpenCloseService {

	private OpenCloseRepository repository;
	
	@Autowired
	public OpenCloseServiceImpl(OpenCloseRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<LocalTime> findAllTimes() {
		return repository.findAllTimes();
	}

	@Override
	public OpenClose findOne(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<OpenClose> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(OpenClose entity) {
		repository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);		
	}

}
