package empre.rubik.api.entites.usuario.enums;

public enum Role {

    CLIENTE("cliente"),
    ADMIN("admin");
    private String role;
    Role(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}
