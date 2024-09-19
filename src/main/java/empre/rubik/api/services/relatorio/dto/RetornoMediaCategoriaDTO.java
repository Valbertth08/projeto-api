package empre.rubik.api.services.relatorio.dto;

import jakarta.validation.constraints.NotNull;

public record RetornoMediaCategoriaDTO(

        @NotNull
        String nome,
        Double peso,
        @NotNull
        Double media

) {
}
