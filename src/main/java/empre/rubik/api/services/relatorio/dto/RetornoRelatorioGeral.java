package empre.rubik.api.services.relatorio.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RetornoRelatorioGeral(

        @NotNull
        List<RetornoMediaCategoriaDTO> lista,
        @NotNull
        Integer mediaGeral,
        @NotNull
        List<String> nomeCategorias
) {
}
