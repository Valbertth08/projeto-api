package empre.rubik.api.entites.cliente.dto;

import empre.rubik.api.entites.cliente.Cliente;
import empre.rubik.api.entites.usuario.enums.Role;

public record DetalharClienteDTO(Long id, String login, String nome) {
    public DetalharClienteDTO(Cliente cliente) {
        this(cliente.getId(),cliente.getLogin(), cliente.getNome());
    }
}
