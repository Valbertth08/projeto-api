package empre.rubik.api.controller;

import empre.rubik.api.entites.formulario.dto.DetalharFormularioDTO;
import empre.rubik.api.services.relatorio.RelatorioService;
import empre.rubik.api.services.relatorio.dto.DadosEntradaRelatorioDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("relatorio")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;
    @GetMapping("/diagnostico")
    public ResponseEntity listarFormulario(@RequestParam Long id, @RequestParam LocalDate data){
        return  ResponseEntity.ok().body(relatorioService.RelatorioGeralBaseadoEmUmCliente(id,data));
    }

}
