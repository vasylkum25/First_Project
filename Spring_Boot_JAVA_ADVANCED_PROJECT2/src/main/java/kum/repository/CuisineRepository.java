package kum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import kum.entity.Cuisine;

public interface CuisineRepository extends JpaNameRepository<Cuisine>, JpaSpecificationExecutor<Cuisine> {

	@Query("SELECT c.name FROM Cuisine c")
	List<String> findAllCuisines();

}
