package empre.rubik.api.repository;

import empre.rubik.api.entites.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {


}
