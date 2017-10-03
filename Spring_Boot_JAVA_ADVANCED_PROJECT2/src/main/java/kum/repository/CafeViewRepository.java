package kum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kum.model.filter.CafeFilter;
import kum.model.view.CafeIndexView;

public interface CafeViewRepository {

	Page<CafeIndexView> findAll(CafeFilter cafeFilter, Pageable pageable);
}
