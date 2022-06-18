package peaksoft.spring_boot_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.spring_boot_rest_api.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByRoleName(String role);
}
