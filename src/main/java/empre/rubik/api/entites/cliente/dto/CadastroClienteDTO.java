package empre.rubik.api.entites.cliente.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CadastroClienteDTO(

        @NotBlank
        @Email
        String login,
        @NotBlank
        String senha,
        @NotBlank
        String nome

) {
}
