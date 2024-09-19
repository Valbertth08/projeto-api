package empre.rubik.api.entites.formulario.dto;

import empre.rubik.api.entites.formulario.Formulario;

import java.time.LocalDateTime;

public record DetalharFormularioDTO(Long id, String titulo, LocalDateTime data) {
    public DetalharFormularioDTO(Formulario formulario){
        this(formulario.getId(),formulario.getTitulo(),formulario.getData());
    }
}

