package edu.tcu.cs.demo.repositories;

import edu.tcu.cs.demo.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
