package empre.rubik.api.dto.dtoPergunta;

import empre.rubik.api.entites.enums.TipoPergunta;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PerguntaCadastroDto(
        @NotBlank
        String texto,
        @NotNull
        TipoPergunta tipoPergunta) {
}
