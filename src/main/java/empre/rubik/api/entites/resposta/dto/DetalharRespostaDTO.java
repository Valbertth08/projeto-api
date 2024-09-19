package empre.rubik.api.entites.resposta.dto;

import empre.rubik.api.entites.resposta.Resposta;

import java.time.LocalDateTime;

public record DetalharRespostaDTO(Long id, Long pergunta_id, Long usuario_id, Long formulario_id, Long valor, LocalDateTime data) {
    public DetalharRespostaDTO(Resposta resposta) {
        this(resposta.getId(),resposta.getPergunta().getId(),resposta.getUsuario().getId(),resposta.getFormulario_id(),resposta.getValor(),resposta.getData());
    }
}

