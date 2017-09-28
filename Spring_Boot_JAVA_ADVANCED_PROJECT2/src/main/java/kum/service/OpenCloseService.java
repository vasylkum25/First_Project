package kum.service;

import kum.entity.OpenClose;
import kum.model.request.OpenCloseRequest;

import java.time.LocalTime;
import java.util.List;

public interface OpenCloseService {

	List<LocalTime> findAllTimes();
	
	OpenCloseRequest findOne(Integer id);
	
	List<OpenClose> findAll();

	void save(OpenCloseRequest openCloseRequest);

	void delete(Integer id);
}
