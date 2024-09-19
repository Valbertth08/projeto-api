package empre.rubik.api.services.relatorio.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DadosEntradaRelatorioDTO(
        @NotNull
        Long id,
        @NotNull
        LocalDate data

) {
}
