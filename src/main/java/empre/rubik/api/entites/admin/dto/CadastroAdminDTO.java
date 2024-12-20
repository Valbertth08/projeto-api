package empre.rubik.api.entites.admin.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CadastroAdminDTO(
        @NotBlank
        @Email
        String login,
        @NotBlank
        String senha,
        @NotBlank
        String nome
) {
}
