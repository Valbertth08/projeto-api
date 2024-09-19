package empre.rubik.api.entites.resposta.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastrarRespostaDTO(
        @NotNull
        Long  id_pergunta,
        @NotNull
        Long id_usuario,
        @NotNull
        Long id_formulario,
        @NotNull
        Long valor

) {
}
