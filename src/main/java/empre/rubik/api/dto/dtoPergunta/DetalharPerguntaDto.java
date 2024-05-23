package empre.rubik.api.dto.dtoPergunta;

import empre.rubik.api.entites.Pergunta;
import empre.rubik.api.entites.enums.TipoPergunta;

public record DetalharPerguntaDto(Long id, String texto, TipoPergunta tipo) {
    public DetalharPerguntaDto(Pergunta pergunta){
        this(pergunta.getId(),pergunta.getTexto(),pergunta.getTipoPergunta());
    }
}
