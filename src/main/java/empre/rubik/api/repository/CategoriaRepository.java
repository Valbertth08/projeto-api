package empre.rubik.api.repository;

import empre.rubik.api.entites.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    @Query("""
            SELECT AVG(R.valor) FROM Pergunta P INNER JOIN Resposta R ON P.id= R.pergunta.id
            INNER JOIN Categoria C ON P.categoria.id = C.id WHERE R.usuario.id = :usuarioId AND C.id = :categoriaId AND
            DATE(R.data)= :data
            """)
    Double pegarMediaBaseadaNaCategoriaDaPergunta(Long usuarioId , Long categoriaId, LocalDate data);


}
