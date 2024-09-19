package empre.rubik.api.repository;

import empre.rubik.api.entites.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
}
