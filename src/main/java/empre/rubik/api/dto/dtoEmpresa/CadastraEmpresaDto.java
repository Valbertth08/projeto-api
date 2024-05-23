package empre.rubik.api.dto.dtoEmpresa;

import empre.rubik.api.entites.Empresa;
import empre.rubik.api.entites.Pergunta;
import jakarta.validation.constraints.NotBlank;

public record CadastraEmpresaDto(
        @NotBlank
        String nome) {
}
