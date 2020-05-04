package pe.creativity.Restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.creativity.Restfull.entity.Role;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {
Optional<Role> findByRoleName(String name);
}
