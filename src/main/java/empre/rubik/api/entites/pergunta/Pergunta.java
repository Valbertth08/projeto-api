package empre.rubik.api.entites.pergunta;

import empre.rubik.api.entites.categoria.Categoria;
import empre.rubik.api.entites.formulario.Formulario;
import empre.rubik.api.entites.resposta.Resposta;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity(name = "Pergunta")
@Table(name ="tb_pergunta")
public class Pergunta  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texto;

    @OneToMany(mappedBy = "pergunta")
    private Set<Resposta> respostas= new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "formulario_id")
    private Formulario formulario;
    public Pergunta(String texto, Formulario formulario, Categoria categoria) {
        this.texto=texto;
        this.formulario=formulario;
        this.categoria=categoria;
    }
}
