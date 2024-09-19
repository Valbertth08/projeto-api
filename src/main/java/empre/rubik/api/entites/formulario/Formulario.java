package empre.rubik.api.entites.formulario;

import empre.rubik.api.entites.formulario.dto.CadastroFormularioDTO;
import empre.rubik.api.entites.pergunta.Pergunta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity(name = "Formulario")
@Table(name = "tb_formulario")
public class Formulario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private LocalDateTime data;
    @OneToMany(mappedBy = "formulario")
    private Set<Pergunta> perguntas=new HashSet<>();

    public Formulario(CadastroFormularioDTO dados) {
        this.titulo=dados.titulo();
        this.data=LocalDateTime.now();
    }
}

