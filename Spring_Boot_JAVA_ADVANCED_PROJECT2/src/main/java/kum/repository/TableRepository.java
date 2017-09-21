package kum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kum.entity.Table;

public interface TableRepository extends JpaRepository<Table, Integer>{

	@Query("SELECT c.name FROM Cafe c")
	List<String> findAllCafes();
	
	@Query("SELECT t FROM Table t LEFT JOIN t.cafe")
	List<Table> findAllTables();
	
	@Query("SELECT DISTINCT t FROM Table t JOIN FETCH t.cafe WHERE t.id=?1")
	Table findOneRequest(Integer id);
}
