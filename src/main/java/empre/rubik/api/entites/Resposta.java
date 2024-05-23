package empre.rubik.api.entites;

import empre.rubik.api.dto.dtoPergunta.PerguntaCadastroDto;
import empre.rubik.api.dto.dtoResposta.CadastroRespostaDto;
import empre.rubik.api.repository.EmpresaRepository;
import empre.rubik.api.repository.PerguntaRepository;
import empre.rubik.api.repository.RespostaRepository;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity(name = "Resposta")
@Table(name = "tb_resposta")
public class Resposta {
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
}
