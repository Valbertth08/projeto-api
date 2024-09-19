package empre.rubik.api.controller;


import empre.rubik.api.entites.pergunta.dto.AtualizarPerguntaDTO;
import empre.rubik.api.entites.pergunta.dto.DetalharPerguntaDTO;
import empre.rubik.api.entites.pergunta.dto.CadastroPerguntaDTO;
import empre.rubik.api.services.PerguntaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("pergunta")
public class PerguntaController {
    @Autowired
    private PerguntaService service;

    @PostMapping("/inserir")
    @Transactional
    public ResponseEntity inserirPergunta(@RequestBody @Valid CadastroPerguntaDTO dados, UriComponentsBuilder builder){
        return  service.inserirPergunta(dados,builder);
    }
    @GetMapping("/listar")
    public ResponseEntity<Page<DetalharPerguntaDTO> > listarPegunta(Pageable pageable){
        return  ResponseEntity.ok().body(service.listarPergunta(pageable));
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity listarPeguntaId(@PathVariable Long id){
        return  service.listarPerguntaId(id);
    }
    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity deletarPeguntaId(@PathVariable Long id){
        return  service.deletarPerguntaId(id);
    }

    @DeleteMapping("/atualizar")
    @Transactional
    public ResponseEntity atualizarPergunta(@RequestBody @Valid AtualizarPerguntaDTO dados){
        return  service.atualizarPergunta(dados);
    }

}
