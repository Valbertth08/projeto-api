package empre.rubik.api.entites.pergunta.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizarPerguntaDTO(

        @NotNull
        Long id,

        String texto


) {
}
