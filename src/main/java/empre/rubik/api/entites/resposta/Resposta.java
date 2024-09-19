package empre.rubik.api.entites.resposta;

import empre.rubik.api.entites.pergunta.Pergunta;
import empre.rubik.api.entites.resposta.dto.CadastrarRespostaDTO;
import empre.rubik.api.entites.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity(name = "Resposta")
@Table(name = "tb_resposta")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long valor;

    @ManyToOne
    @JoinColumn(name ="pergunta_id")
    private Pergunta pergunta;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private Long  formulario_id;
    private LocalDateTime data;
    public Resposta(Pergunta pergunta, Usuario usuario, Long id_formulario, Long valor) {
        this.formulario_id=id_formulario;
        this.usuario=usuario;
        this.pergunta=pergunta;
        this.valor=valor;
        this.data=LocalDateTime.now();
    }
}
