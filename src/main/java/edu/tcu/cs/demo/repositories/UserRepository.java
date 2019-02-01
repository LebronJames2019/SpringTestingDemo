package edu.tcu.cs.demo.repositories;

import edu.tcu.cs.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
