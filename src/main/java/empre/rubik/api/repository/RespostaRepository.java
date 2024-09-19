package empre.rubik.api.repository;

import empre.rubik.api.entites.resposta.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface RespostaRepository extends JpaRepository<Resposta,Long> {

    @Query("""
            select count(R) > 0 from Resposta R
            where DATE(R.data)= :data
            and R.usuario.id= :id
            """)
    Boolean validarClienteAgendamentoMesmoDia(LocalDate data, Long id);

}
