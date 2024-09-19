package empre.rubik.api.controller;


import empre.rubik.api.entites.resposta.dto.CadastrarRespostaDTO;
import empre.rubik.api.services.RespostaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("respostas")
public class RespostaController {
    @Autowired
    private RespostaService service;
    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastrarRespostaDTO dados, UriComponentsBuilder builder){
        return  service.cadastrar(dados,builder);
    }
}
