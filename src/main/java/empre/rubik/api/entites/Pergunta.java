package empre.rubik.api.entites;

import empre.rubik.api.dto.dtoPergunta.PerguntaCadastroDto;
import empre.rubik.api.entites.enums.TipoPergunta;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


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

    @Enumerated(EnumType.STRING)
    private TipoPergunta tipoPergunta;

    @OneToOne(mappedBy = "pergunta")
    private Resposta resposta;

}
