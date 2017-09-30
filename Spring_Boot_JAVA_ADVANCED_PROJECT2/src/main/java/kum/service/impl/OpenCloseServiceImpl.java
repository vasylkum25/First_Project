package kum.service.impl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import kum.entity.OpenClose;
import kum.model.filter.SimpleFilter;
import kum.model.request.OpenCloseRequest;
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
	public OpenCloseRequest findOne(Integer id) {
		OpenClose openClose = repository.findOne(id);
		OpenCloseRequest openCloseRequest = new OpenCloseRequest();
		openCloseRequest.setId(openClose.getId());
		openCloseRequest.setTime(openClose.getTime().format(DateTimeFormatter.ofPattern("HH:mm")));
		return openCloseRequest;
	}

	@Override
	public List<OpenClose> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(OpenCloseRequest openCloseRequest) {
		OpenClose openClose = new OpenClose();
		openClose.setId(openCloseRequest.getId());
		openClose.setTime(LocalTime.parse(openCloseRequest.getTime()));
		repository.save(openClose);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);		
	}

	@Override
	public Page<OpenClose> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Page<OpenClose> findAll(Pageable pageable, SimpleFilter filter) {
		return repository.findAll(filter(filter), pageable);
		
	}
	
	public Specification<OpenClose> filter(SimpleFilter filter){
		return (root, cq, cb) -> {
			if(filter.getSearch().isEmpty()) return null; 
				return cb.equal(root.get("time"), LocalTime.parse(filter.getSearch()));
		}; 
	}

	
}
