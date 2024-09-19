package empre.rubik.api.entites.cliente;

import empre.rubik.api.entites.cliente.dto.CadastroClienteDTO;
import empre.rubik.api.entites.resposta.Resposta;
import empre.rubik.api.entites.usuario.Usuario;
import empre.rubik.api.entites.usuario.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@Entity(name = "Cliente")
@Table(name = "tb_cliente")
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Cliente extends Usuario {
    private String nome;
    private static BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    public Cliente(CadastroClienteDTO dados) {
        super( dados.login(), passwordEncoder.encode(dados.senha()),Role.CLIENTE);
        this.nome = dados.nome();
    }
}
