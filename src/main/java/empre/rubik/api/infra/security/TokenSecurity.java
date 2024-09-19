package empre.rubik.api.infra.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import empre.rubik.api.entites.admin.Admin;
import empre.rubik.api.entites.cliente.Cliente;
import empre.rubik.api.entites.usuario.Usuario;
import empre.rubik.api.entites.usuario.enums.Role;
import empre.rubik.api.repository.ClienteRepository;
import org.aspectj.weaver.ast.Instanceof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
@Service
public class TokenSecurity {

    @Autowired
    private ClienteRepository clienteRepository;
    public String gerarToken(Usuario usuario){;
        try {
            var algoritimo = Algorithm.HMAC256("123456");
            var jwtBuilder = JWT.create()
                    .withIssuer("API rubick")
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId());

            if (usuario.getRole()==Role.CLIENTE && clienteRepository.existsById(usuario.getId())) {
                Cliente cliente = clienteRepository.getReferenceById(usuario.getId());
                jwtBuilder.withClaim("nome", cliente.getNome());
            }
            return jwtBuilder.sign(algoritimo);
        }catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token",exception);
        }
    }
    public String validarToken(String token) {
        try {
            var algoritimo = Algorithm.HMAC256("123456");
            return JWT.require(algoritimo)
                    .withIssuer("API rubick")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token invalido ou expirado");
        }
    }
    public Instant dataExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
