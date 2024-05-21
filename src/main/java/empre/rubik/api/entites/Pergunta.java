package empre.rubik.api.entites;

import empre.rubik.api.dto.dtoPergunta.PerguntaCadastroDto;
import empre.rubik.api.entites.enums.TipoPergunta;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity(name = "Pergunta")
@Table(name ="tb_pergunta")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter

public class Pergunta  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texto;

    @Enumerated(EnumType.STRING)
    private TipoPergunta tipoPergunta;

    @OneToOne(mappedBy = "pergunta")
    private Resposta resposta;
    public Pergunta(PerguntaCadastroDto perguntaCadastroDto){
        this.id=perguntaCadastroDto.id();
        this.texto=perguntaCadastroDto.texto();
        this.tipoPergunta=perguntaCadastroDto.tipoPergunta();
    }
}
