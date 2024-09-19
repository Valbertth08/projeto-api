package empre.rubik.api.entites.pergunta.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroPerguntaDTO(
        @NotBlank
        String texto,
        @NotNull
        Long idFormulario,
        @NotNull
        Long idCategoria

) {
}
