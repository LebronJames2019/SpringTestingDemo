package edu.tcu.cs.demo.repositories;

import edu.tcu.cs.demo.domain.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepsoitory extends JpaRepository<Role, Integer> {
}
