package empre.rubik.api.services;

import empre.rubik.api.entites.usuario.Usuario;
import empre.rubik.api.entites.usuario.dto.EfetuarLoginDTO;
import empre.rubik.api.entites.usuario.dto.RetornoTokenDTO;
import empre.rubik.api.infra.security.TokenSecurity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UsuarioService {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenSecurity tokenSecurity;

    public ResponseEntity login(@RequestBody @Valid EfetuarLoginDTO dados){
        try {
            var dadosAutenticacao = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
            var authentication = manager.authenticate(dadosAutenticacao);
            var tokenJWT = tokenSecurity.gerarToken(((Usuario) authentication.getPrincipal()));
            return ResponseEntity.ok(new RetornoTokenDTO(tokenJWT));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

