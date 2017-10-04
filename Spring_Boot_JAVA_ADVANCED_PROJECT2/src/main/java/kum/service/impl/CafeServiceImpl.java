package kum.service.impl;


import java.security.Principal;
import java.time.LocalTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import kum.entity.Cafe;
import kum.entity.OpenClose;
import kum.entity.Type;
import kum.model.filter.CafeFilter;
import kum.model.filter.SimpleFilter;
import kum.model.request.CafeRequest;
import kum.model.view.CafeIndexView;
import kum.model.view.CafeView;
import kum.repository.CafeRepository;
import kum.repository.CafeViewRepository;
import kum.repository.OpenCloseRepository;
import kum.repository.OwnCafeViewRepository;
import kum.repository.UserRepository;
import kum.service.CafeService;

@Service
public class CafeServiceImpl implements CafeService  {
	
	private final CafeRepository repository;
	private final UserRepository userRepository;
	private final CafeViewRepository cafeViewRepository;
	private final OwnCafeViewRepository ownCafeViewRepository;
	private final OpenCloseRepository openCloseRepository;
	@Autowired
	public CafeServiceImpl(CafeRepository repository, UserRepository userRepository, CafeViewRepository cafeViewRepository, OwnCafeViewRepository ownCafeViewRepository, OpenCloseRepository openCloseRepository) {
		this.repository = repository;
		this.userRepository = userRepository;
		this.cafeViewRepository = cafeViewRepository;
		this.ownCafeViewRepository = ownCafeViewRepository;
		this.openCloseRepository = openCloseRepository;
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
		request.setClose(cafe.getClose().getTime());
		request.setOpen(cafe.getOpen().getTime());
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
		cafe.setClose(openCloseRepository.findByTime(request.getClose()));
		cafe.setOpen(openCloseRepository.findByTime(request.getOpen()));
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

	@Override
	public Page<CafeIndexView> findAllIndexViews(Pageable pageable) {
		return repository.findAllIndexViews(pageable);
	}

	@Override
	public Page<CafeIndexView> findAllCafesByUser(String email, Pageable pageable) {
		return repository.findAllCafesByUser(email, pageable);
	}

	@Override
	public Page<CafeIndexView> findAllIndexViews(Pageable pageable, SimpleFilter filter) {
		return repository.findAll(filter(filter), pageable);
	}

	public Specification<CafeIndexView> filter(SimpleFilter filter){
		return (root, cq, cb) -> {
				if(filter.getSearch().isEmpty()) return null;
				return cb.like(root.get("name"), filter.getSearch()+"%");
		};
	}

	@Override
	public Page<CafeIndexView> findAll(CafeFilter cafeFilter, Pageable pageable) {
		return cafeViewRepository.findAll(cafeFilter, pageable);
	}

	@Override
	public Page<CafeIndexView> findAll(CafeFilter cafeFilter, Pageable pageable, Principal principal) {
		return ownCafeViewRepository.findAll(cafeFilter, pageable, principal);
	}
}

	
