package empre.rubik.api.entites.formulario.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CadastroFormularioDTO(
        @NotNull
        String titulo) {
}
