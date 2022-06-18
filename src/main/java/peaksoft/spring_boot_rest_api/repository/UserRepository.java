package peaksoft.spring_boot_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.spring_boot_rest_api.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
}
