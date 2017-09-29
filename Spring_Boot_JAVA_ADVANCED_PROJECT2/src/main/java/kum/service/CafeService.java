package kum.service;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kum.model.request.CafeRequest;
import kum.model.view.CafeIndexView;
import kum.model.view.CafeView;

public interface CafeService{
	
	List<String> findAllCafes();
		
	List<CafeIndexView> findAllIndexViews();

	CafeRequest findOneCafe(Integer id);
	
	CafeView findCafeViewId(Integer id);
	
	void save(CafeRequest request, Principal principal);
	
	void delete(Integer id);

	List<CafeIndexView> findAllCafesByUser(String email);
	
	Page<CafeIndexView> findAllCafesByUser(String email, Pageable pageable);

	Page<CafeIndexView> findAllIndexViews(Pageable pageable);
	
	

	
}
