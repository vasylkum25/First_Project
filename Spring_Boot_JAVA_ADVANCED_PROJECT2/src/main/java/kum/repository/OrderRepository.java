package kum.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import kum.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}

