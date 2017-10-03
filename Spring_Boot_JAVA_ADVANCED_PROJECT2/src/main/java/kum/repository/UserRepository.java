package kum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kum.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	
	@Query("SELECT u.id FROM User u WHERE u.email=?1")
	Integer findByUserLogin(String email);
}
