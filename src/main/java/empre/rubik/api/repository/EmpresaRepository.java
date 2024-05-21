package empre.rubik.api.repository;

import empre.rubik.api.entites.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa,Long> {
}
