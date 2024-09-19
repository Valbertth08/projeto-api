package empre.rubik.api.entites.formulario.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizarFormularioDTO(
        @NotNull
        Long id,
        String titulo)
{
}
