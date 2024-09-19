package empre.rubik.api.controller;


import empre.rubik.api.entites.usuario.Usuario;
import empre.rubik.api.entites.usuario.dto.EfetuarLoginDTO;
import empre.rubik.api.entites.usuario.dto.RetornoTokenDTO;
import empre.rubik.api.infra.security.TokenSecurity;
import empre.rubik.api.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid EfetuarLoginDTO dados){
        return service.login(dados);
    }

}
