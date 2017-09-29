package kum.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import kum.entity.Cafe;
import kum.model.view.CafeView;
import kum.model.view.CafeIndexView;

public interface CafeRepository extends JpaNameRepository<Cafe> {
	
	@Query("SELECT new kum.model.view.CafeIndexView(c.id, c.rate, c.name, c.photoUrl, c.address, c.shortDescription, c.type) FROM Cafe c")
	List<CafeIndexView> findAllIndexViews();
	
	@Query(value = "SELECT new kum.model.view.CafeIndexView(c.id, c.rate, c.name, c.photoUrl, c.address, c.shortDescription, c.type) FROM Cafe c",
			countQuery="SELECT count(c.id) FROM Cafe c")
	Page<CafeIndexView> findAllIndexViews(Pageable pageable);
	
	@Query("SELECT DISTINCT cafe FROM Cafe cafe JOIN FETCH cafe.open JOIN FETCH cafe.close WHERE cafe.id=?1")
	Cafe findOne(Integer id);
	
	@Query("SELECT new kum.model.view.CafeView(c.id, c.rate, c.name, c.photoUrl, c.version, c.address, c.fullDescription, c.type, c.phone, c.web, open.time, close.time) FROM Cafe c LEFT JOIN c.open open LEFT JOIN c.close close WHERE c.id=?1")
	CafeView findCafeViewById(Integer id);
	
	@Query("SELECT ca.name FROM Cafe ca")
	List<String> findAllCafe();

	@Query("SELECT new kum.model.view.CafeIndexView(c.id, c.rate, c.name, c.photoUrl, c.address, c.shortDescription, c.type) FROM Cafe c JOIN c.user u WHERE u.email=?1")
	List<CafeIndexView> findAllCafesByUser(String email);
	
	@Query(value="SELECT new kum.model.view.CafeIndexView(c.id, c.rate, c.name, c.photoUrl, c.address, c.shortDescription, c.type) FROM Cafe c JOIN c.user u WHERE u.email=?1",
			countQuery="SELECT count(c.id) FROM Cafe c JOIN c.user u WHERE u.email=?1")
	Page<CafeIndexView> findAllCafesByUser(String email, Pageable pageable);

}
