package empre.rubik.api.repository;

import empre.rubik.api.entites.pergunta.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {
}
