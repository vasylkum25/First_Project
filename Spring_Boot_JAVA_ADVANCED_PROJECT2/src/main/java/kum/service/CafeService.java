package kum.service;

import java.security.Principal;
import java.util.List;

import kum.model.request.CafeRequest;
import kum.model.view.CafeIndexView;
import kum.model.view.CafeView;

public interface CafeService{
	
	List<String> findAllCafes();
	
	List<CafeView> findAllViews();
		
	List<CafeIndexView> findAllIndexViews();

	CafeRequest findOneCafe(Integer id);
	
	CafeView findCafeViewId(Integer id);
	
	void save(CafeRequest request, Principal principal);
	
	void delete(Integer id);

	List<CafeIndexView> findAllCafesByUser(String email);
	
	

	
}
