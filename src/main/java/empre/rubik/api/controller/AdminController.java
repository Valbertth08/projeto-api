package empre.rubik.api.controller;

import empre.rubik.api.entites.admin.dto.AtualizarAdminDTO;
import empre.rubik.api.entites.admin.dto.CadastroAdminDTO;
import empre.rubik.api.entites.admin.dto.DetalharAdminDTO;
import empre.rubik.api.services.AdminService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @PostMapping("/inserir")
    @Transactional
    public ResponseEntity inserirAdmin(@RequestBody @Valid CadastroAdminDTO dados, UriComponentsBuilder builder){
        return  service.inserirAdmin(dados,builder);
    }
    @PostMapping("/atualizar")
    @Transactional
    public ResponseEntity atualizarAdmin(@RequestBody @Valid AtualizarAdminDTO dados){
        return service.atualizarAdmin(dados);
    }
    @GetMapping("/listar")
    public ResponseEntity<Page<DetalharAdminDTO>> listarAdmin(Pageable pageable) {
        return ResponseEntity.ok().body(service.listarAdmin(pageable));
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity  listarAdminId(@PathVariable Long id){
        return service.listarAdminId(id);
    }
    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity deletarAdminId(@PathVariable Long id){
        service.deletarAdminId(id);
        return ResponseEntity.noContent().build();
    }

}
