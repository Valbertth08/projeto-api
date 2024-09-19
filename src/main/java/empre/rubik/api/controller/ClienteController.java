package empre.rubik.api.controller;


import empre.rubik.api.entites.cliente.dto.AtualizarClienteDTO;
import empre.rubik.api.entites.cliente.dto.CadastroClienteDTO;
import empre.rubik.api.entites.cliente.dto.DetalharClienteDTO;
import empre.rubik.api.services.ClienteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping("/inserir")
    @Transactional
    public ResponseEntity inserirCliente(@RequestBody @Valid CadastroClienteDTO dados, UriComponentsBuilder builder){
        return  service.inserirCliente(dados,builder);
    }
    @PostMapping("/atualizar")
    @Transactional
    public ResponseEntity atualizarCliente(@RequestBody @Valid AtualizarClienteDTO dados){
        return service.atualizarCliente(dados);
    }
    @GetMapping("/listar")
    public ResponseEntity<Page<DetalharClienteDTO>> listarCliente(Pageable pageable) {
        return ResponseEntity.ok().body(service.listarCliente(pageable));
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity  listarClienteId(@PathVariable Long id){
        return service.listarClienteId(id);
    }
    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity deletarCleienteId(@PathVariable Long id){
        service.deletarClienteId(id);
        return ResponseEntity.noContent().build();
    }

}
