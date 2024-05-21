package empre.rubik.api.dto.dtoResposta;

import empre.rubik.api.entites.Empresa;
import empre.rubik.api.entites.Pergunta;
import empre.rubik.api.entites.Resposta;

public record DetalharRespostaDto(Long id, String texto, Pergunta pergunta, Empresa empresa) {
    public DetalharRespostaDto(Resposta resposta){
        this(resposta.getId(),resposta.getTexto(),resposta.getPergunta(),resposta.getEmpresa());
    }
}
