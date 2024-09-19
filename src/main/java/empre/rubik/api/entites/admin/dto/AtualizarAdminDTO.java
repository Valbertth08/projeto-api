package empre.rubik.api.entites.admin.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizarAdminDTO(
        @NotNull
        Long id,
        String nome
) {
}
