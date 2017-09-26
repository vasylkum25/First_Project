package kum.service.impl;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kum.entity.Cafe;
import kum.entity.Type;
import kum.model.request.CafeRequest;
import kum.model.view.CafeIndexView;
import kum.model.view.CafeView;
import kum.repository.CafeRepository;
import kum.repository.UserRepository;
import kum.service.CafeService;

@Service
public class CafeServiceImpl implements CafeService  {
	
	private final CafeRepository repository;
	
	private final UserRepository userRepository;
	
	@Autowired
	public CafeServiceImpl(CafeRepository repository, UserRepository userRepository) {
		this.repository = repository;
		this.userRepository = userRepository;
	}

	@Override
	public List<CafeView> findAllViews() {
		List<CafeView> views = repository.findAllViews();
		return views;
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	@Override
	public List<CafeIndexView> findAllIndexViews() {
		return repository.findAllIndexViews();
	}

	@Override
	public CafeRequest findOneCafe(Integer id) {
		Cafe cafe = repository.findOne(id);
		CafeRequest request = new CafeRequest();
		request.setAddress(cafe.getAddress());
		request.setClose(cafe.getClose());
		request.setOpen(cafe.getOpen());
		request.setFullDescription(cafe.getFullDescription());
		request.setId(cafe.getId());
		request.setName(cafe.getName());
		request.setWeb(cafe.getWeb());
		request.setPhone(cafe.getPhone());
		request.setPhotoUrl(cafe.getPhotoUrl());
		request.setRate(cafe.getRate());
		request.setShortDescription(cafe.getShortDescription());
		request.setType(String.valueOf(cafe.getType()));
		request.setVersion(cafe.getVersion());		
		return request;
	}

	@Override
	public void save(CafeRequest request, Principal principal) {
		Cafe cafe = new Cafe();
		cafe.setAddress(request.getAddress());
		cafe.setClose(request.getClose());
		cafe.setOpen(request.getOpen());
		cafe.setFullDescription(request.getFullDescription());
		cafe.setId(request.getId());
		cafe.setName(request.getName());
		cafe.setWeb(request.getWeb());
		cafe.setPhone(request.getPhone());
		cafe.setPhotoUrl(request.getPhotoUrl());
		cafe.setRate(request.getRate());
		cafe.setShortDescription(request.getShortDescription());
		cafe.setType(Type.valueOf(request.getType()));
		cafe.setVersion(request.getVersion());
		cafe.setUser(userRepository.findByEmail(principal.getName()));
		repository.save(cafe);
	}

	@Override
	public CafeView findCafeViewId(Integer id) {
		return repository.findCafeViewById(id);
	}

	@Override
	public List<String> findAllCafes() {
		return repository.findAllCafe();
	}

	@Override
	public List<CafeIndexView> findAllCafesByUser(String email) {
		return repository.findAllCafesByUser(email);
	}

}

	