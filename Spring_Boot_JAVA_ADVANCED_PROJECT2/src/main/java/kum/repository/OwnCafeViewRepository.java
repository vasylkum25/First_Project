package kum.repository;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kum.model.filter.CafeFilter;
import kum.model.view.CafeIndexView;

public interface OwnCafeViewRepository {

	Page<CafeIndexView> findAll(CafeFilter cafeFilter, Pageable pageable, Principal principal);
	
}
