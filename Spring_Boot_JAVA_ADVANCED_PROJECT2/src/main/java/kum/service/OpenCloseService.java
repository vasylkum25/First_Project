package kum.service;

import kum.entity.OpenClose;
import kum.model.request.OpenCloseRequest;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OpenCloseService {

	List<LocalTime> findAllTimes();
	
	OpenCloseRequest findOne(Integer id);
	
	List<OpenClose> findAll();
	
	Page<OpenClose> findAll(Pageable pageable);

	void save(OpenCloseRequest openCloseRequest);

	void delete(Integer id);
}
