package empre.rubik.api.entites.admin.dto;

import empre.rubik.api.entites.admin.Admin;
import empre.rubik.api.entites.usuario.enums.Role;

public record DetalharAdminDTO(Long id, String login,  String nome) {
    public DetalharAdminDTO(Admin admin) {
        this(admin.getId(),admin.getLogin(), admin.getNome());
    }
}
