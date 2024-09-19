package empre.rubik.api.entites.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record EfetuarLoginDTO(
        @NotNull
        @Email
        String login,
        @NotNull
        String senha

) {
}
