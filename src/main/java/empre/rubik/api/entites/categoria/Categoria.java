package empre.rubik.api.entites.categoria;

import empre.rubik.api.entites.pergunta.Pergunta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Categoria")
@Table(name = "tb_categoria")
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double peso;
    @OneToMany(mappedBy ="categoria")
    private Set<Pergunta> perguntas = new HashSet<>();
}
