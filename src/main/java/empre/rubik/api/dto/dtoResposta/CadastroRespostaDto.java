package empre.rubik.api.dto.dtoResposta;

import empre.rubik.api.entites.Empresa;
import empre.rubik.api.entites.Pergunta;
import empre.rubik.api.entites.Resposta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroRespostaDto(
        @NotNull
        Long id,
        @NotBlank
        String texto,
        @NotNull
        Pergunta pergunta,
        @NotNull
        Empresa empresa) {
}
