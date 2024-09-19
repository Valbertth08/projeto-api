package empre.rubik.api.controller;


import empre.rubik.api.entites.formulario.dto.AtualizarFormularioDTO;
import empre.rubik.api.entites.formulario.dto.CadastroFormularioDTO;
import empre.rubik.api.entites.formulario.dto.DetalharFormularioDTO;
import empre.rubik.api.services.FormularioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/formulario")
public class FormularioController {
    @Autowired
    private FormularioService service;

    @PostMapping("/inserir")
    @Transactional
    public ResponseEntity inserirFormulario(@RequestBody @Valid CadastroFormularioDTO dados, UriComponentsBuilder builder){
        return  service.inserirFormulario(dados,builder);
    }
    @GetMapping("/listar")
    public ResponseEntity<Page<DetalharFormularioDTO>> listarFormulario(Pageable pageable){
        return  ResponseEntity.ok().body(service.listarFormulario(pageable));
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity listarForularioId(@PathVariable Long id){
        return  service.listarFormularioId(id);
    }
    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity deletarFormularioId(@PathVariable Long id){
        return   service.deletarFormularioId(id);
    }
    @DeleteMapping("/atualizar")
    @Transactional
    public ResponseEntity atulizarFormulario(@RequestBody @Valid AtualizarFormularioDTO dados){
        return  service.atualizarFormulario(dados);
    }
}
