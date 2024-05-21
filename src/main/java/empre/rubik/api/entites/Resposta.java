package empre.rubik.api.entites;

import empre.rubik.api.dto.dtoResposta.CadastroRespostaDto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity(name = "Resposta")
@Table(name = "tb_resposta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Resposta{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="pergunta_id")
    private Pergunta pergunta;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Resposta(CadastroRespostaDto cadastro){
        this.id=cadastro.id();
        this.empresa=cadastro.empresa();
        this.texto=cadastro.texto();
        this.pergunta=cadastro.pergunta();
    }
}
