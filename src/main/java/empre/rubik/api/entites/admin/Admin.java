package empre.rubik.api.entites.admin;

import empre.rubik.api.entites.admin.dto.CadastroAdminDTO;
import empre.rubik.api.entites.cliente.dto.CadastroClienteDTO;
import empre.rubik.api.entites.usuario.Usuario;
import empre.rubik.api.entites.usuario.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Entity(name = "Admin")
@Table(name = "tb_admin")
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Admin extends Usuario{
        private String nome;
        private static BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

        public Admin(CadastroAdminDTO dados) {
            super( dados.login(), passwordEncoder.encode(dados.senha()), Role.ADMIN);
            this.nome = dados.nome();
        }
}
