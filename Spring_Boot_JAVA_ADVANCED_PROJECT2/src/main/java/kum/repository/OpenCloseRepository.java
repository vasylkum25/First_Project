package kum.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kum.entity.OpenClose;

public interface OpenCloseRepository extends JpaRepository<OpenClose, Integer> {

	OpenClose findByTime(LocalTime time);
	
	@Query("SELECT t.time FROM OpenClose t")
	List<LocalTime> findAllTimes();
}
