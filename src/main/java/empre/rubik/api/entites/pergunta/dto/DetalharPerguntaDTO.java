package empre.rubik.api.entites.pergunta.dto;

import empre.rubik.api.entites.pergunta.Pergunta;

public record DetalharPerguntaDTO(Long id, String texto, Long idForm ) {
    public DetalharPerguntaDTO(Pergunta pergunta){
        this(pergunta.getId(),pergunta.getTexto(),pergunta.getFormulario().getId());
    }
}
