package empre.rubik.api.entites.cliente.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizarClienteDTO(
        @NotNull
        Long id,
        String nome
) {
}
